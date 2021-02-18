package com.gracie.ecommerce.web.cart;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.service.CartService;
import com.gracie.ecommerce.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cart")
public class CartRestController {

    @Autowired
    CartService cartServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<?> saveCart(Cart cart)throws Exception{
        try{
            cartServiceImpl.saveCart(cart);
        }


        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCart/{id}")
    public void deleteCart (@PathVariable("id") Integer id){
        try{
            cartServiceImpl.deleteCart(id);
        }

        catch (Exception e) {

            ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
