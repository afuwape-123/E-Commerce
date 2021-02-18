package com.gracie.ecommerce.web.Payment;

import com.gracie.ecommerce.Dto.InitializeTransactionRequestDTO;
import com.gracie.ecommerce.Dto.InitializeTransactionResponseDto;
import com.gracie.ecommerce.service.InitializeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
public class InitializeTransactionController {

    @Autowired
    private InitializeTransactionService initializeTransactionService;

//    @RequestMapping(path = "/initializetransaction", method = RequestMethod.POST)
    @PostMapping("/initializetransaction")
    public InitializeTransactionResponseDto initializeTransaction(@RequestBody
                                                                  InitializeTransactionRequestDTO
                                                                  initializeTransactionRequestDTO){
        InitializeTransactionResponseDto initializeTransaction = initializeTransactionService.initializeTransaction
                (initializeTransactionRequestDTO);

        return initializeTransaction;
    }

}
