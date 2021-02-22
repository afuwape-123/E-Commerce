/*
 Copyright (c) 2020. Semicolon Africa
 312 Herbert Macaulay Way, Yaba, Lagos.

 Project Name: lamp
 Class Name: com.lamp.service.dtos.JWTToken
 File Name: JWTToken.java
 File Path: /home/scv2003/IdeaProjects/lampOnboarding/models/src/main/java/com/lamp/dtos/JWTToken.java
 @author:  scv2003
 Last Modified: 04/05/2020, 8:45 PM.

 The contents of this file and project are not available to the public.


 */

package com.gracie.ecommerce.security.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTToken {
    private String accessToken;
    private TokenType tokenType = TokenType.BEARER_TOKEN;


    public JWTToken(String accessToken) {
        this.accessToken = accessToken;
    }


}