package com.gracie.ecommerce.Dto;

import com.gracie.ecommerce.data.model.Channels;
import com.gracie.ecommerce.data.model.PaystackBearer;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class InitializeTransactionRequestDTO {

    private String amount;
    private String email;
    private String reference;
    private String callback_url;
    private Integer invoice_limit;
    private Channels[] channels;
    private String subAccount;
    private Integer transaction_charge;

    @Enumerated(EnumType.STRING)
    private PaystackBearer paystackBearer = PaystackBearer.ACCOUNT;
}
