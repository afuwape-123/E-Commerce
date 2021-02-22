package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.InitializeTransactionRequestDTO;
import com.gracie.ecommerce.Dto.InitializeTransactionResponseDto;

public interface InitializeTransactionService {
    InitializeTransactionResponseDto initializeTransaction(
            InitializeTransactionRequestDTO initializeTransactionRequestDto);
}
