package com.example.demo.service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.model.User;

public interface UserServices {
    User register(RegisterDTO registerDTO);
    User login(LoginDTO loginDTO);
}
