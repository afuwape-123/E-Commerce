package com.gracie.ecommerce.web.cart;


import com.gracie.ecommerce.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartRestController {

    @Autowired
    CartServiceImpl cartServiceImpl;


}
