package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.InitializeTransactionResponseDto;
import com.gracie.ecommerce.Dto.InitializeTransactionRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class  InitializeTransactionServiceImpl implements InitializeTransactionService{
   RestTemplate restTemplate = new RestTemplate();

   @Value("${paystackApiKey}")
   private String paystackApiKey;

    @Override
    public InitializeTransactionResponseDto initializeTransaction(InitializeTransactionRequestDTO initializeTransactionRequestDTO) {
        String url = "https: //api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        String key = paystackApiKey;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer" + key);
        HttpEntity<InitializeTransactionRequestDTO> entity
                = new HttpEntity<InitializeTransactionRequestDTO>(initializeTransactionRequestDTO, headers);
        ResponseEntity<InitializeTransactionResponseDto>
                response = restTemplate.postForEntity(url, entity,InitializeTransactionResponseDto.class);


        return response.getBody();
    }
}