package com.gracie.ecommerce.web.cart;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.service.CartService;
import com.gracie.ecommerce.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartRestController {

    @Autowired
    CartServiceImpl cartServiceImpl;


}
