package com.example.demo.DTO;

import lombok.Data;

@Data
public class JwtResponse {
    private String jwtToken;
    private String message;

    public JwtResponse(String token, String message){
        this.jwtToken = token;
        this.message = message;
    }
}
