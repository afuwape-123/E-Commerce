package com.gracie.ecommerce.security.security;


import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.data.repositories.UserRepository;
import com.gracie.ecommerce.security.dtos.UserLoginRequestDTO;
import com.gracie.ecommerce.security.exception.AuthorizationException;
import com.gracie.ecommerce.security.utils.TokenProviderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserPrincipalService implements UserDetailsService, UserDetails {
    private final int BEARER_TOKEN_PREFIX = 7;

    private final Logger logger = LoggerFactory.getLogger(UserPrincipalService.class);
//
//    @Autowired
//    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenProviderUtil tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;



    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public UserDetails loadUserByEmail(String email)
            throws UsernameNotFoundException {
        return loadUserByUsername(email);
    }





//    public Set<SimpleGrantedAuthority> getAuthority(User user) {
////        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
////        user.getRoles().forEach(role -> {
////
////            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
////        });
////        return authorities;
//       return new SimpleGrantedAuthority("ROLE_"+user.getRole());
//
//    }

    public SimpleGrantedAuthority getAuthority(User user){
        return new SimpleGrantedAuthority("ROLE_"+user.getRole());
    }


    public String convertBearerTokenToUserEmail(String bearerToken) {

        return tokenProvider.getEmailFromToken(bearerToken.substring(BEARER_TOKEN_PREFIX));
    }




    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return null;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return null;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return false;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("User not found with username or email : " + username);
        }
        else{
            User user = optionalUser.get();
            return UserPrincipal.create(user);

        }

    }


    public JWTToken loginUser(UserLoginRequestDTO userLoginRequestDTO) throws AuthorizationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequestDTO.getEmail(),
                        userLoginRequestDTO.getPassword()
                )
        );
        logger.info("authenticated");
        logger.info("setting authorization for "+ userLoginRequestDTO.getEmail());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        logger.info("generating token");
        User user = userRepository.findUserByEmail(userLoginRequestDTO.getEmail());

    return new JWTToken(tokenProvider.generateLoginToken(authentication, user));

    }



}

