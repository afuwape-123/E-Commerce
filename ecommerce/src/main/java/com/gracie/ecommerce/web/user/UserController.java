package com.gracie.ecommerce.web.user;


import com.gracie.ecommerce.Dto.DtoUserRegistration;
import com.gracie.ecommerce.Exceptions.RegisterException;
import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.security.dtos.UserLoginRequestDTO;
import com.gracie.ecommerce.service.UserService;
import com.gracie.ecommerce.service.UserServiceImpl;
import com.gracie.ecommerce.web.dtos.ApiResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Service
@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService ;

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(DtoUserRegistration dtoUserRegistration) {
        try{
            userService.registerUser(dtoUserRegistration);
        }

        catch (RegisterException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(dtoUserRegistration);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser( @PathVariable Integer id){
        try{
            userService.deleteUser(id);
        }

        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping("/save")
    public  ResponseEntity<?> saveUser(User user)throws Exception{
        try{
            userService.saveUser(user);
        }

        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/checkUser/{email}")
    public ResponseEntity<?> checkIfUserExistsByEmail(@PathVariable("email")  String email)throws Exception{
        try{
            userService.checkIfUserExistsByEmail(email);
        }

        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginRequestDTO userLoginRequestDTO){
        //@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
        try
        {
            return new ResponseEntity<>(userService.loginUser(userLoginRequestDTO), HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.UNAUTHORIZED);
        }


    }

}
