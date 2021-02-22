package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.InitializeTransactionResponseDto;
import com.gracie.ecommerce.Dto.InitializeTransactionRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class  InitializeTransactionServiceImpl implements InitializeTransactionService{
   RestTemplate restTemplate = new RestTemplate();

    @Override
    public InitializeTransactionResponseDto initializeTransaction(InitializeTransactionRequestDTO initializeTransactionRequestDTO) {
        String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        String key = "sk_test_7d3a04e5f7114ebccfaca580089476413278f1d8";
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer" + key);
        HttpEntity<InitializeTransactionRequestDTO> entity
                = new HttpEntity<InitializeTransactionRequestDTO>(initializeTransactionRequestDTO, headers);
        ResponseEntity<InitializeTransactionResponseDto>
                response = restTemplate.postForEntity(url, entity,InitializeTransactionResponseDto.class);


        return response.getBody();
    }
}