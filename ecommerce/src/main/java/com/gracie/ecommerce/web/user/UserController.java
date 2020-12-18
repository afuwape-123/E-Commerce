package com.gracie.ecommerce.web.user;


import com.gracie.ecommerce.Dto.DtoUserRegistration;
import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    UserServiceImpl userService ;

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(DtoUserRegistration dtoUserRegistration)throws Exception{
        try{
            userService.registerUser(dtoUserRegistration);
        }

        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(User user)throws Exception{
        try{
            userService.deleteUser(user);
        }

        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.IM_USED);

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

    @PostMapping("/checkUser")
    public ResponseEntity<?> checkIfUserExistsByEmail(String email)throws Exception{
        try{
            userService.checkIfUserExistsByEmail(email);
        }

        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
