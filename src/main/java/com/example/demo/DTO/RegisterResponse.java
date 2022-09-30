package com.example.demo.DTO;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterResponse {
    private String message;
    private User data;

    public RegisterResponse(String message, User data) {
        this.message = message;
        this.data = data;
    }
}
