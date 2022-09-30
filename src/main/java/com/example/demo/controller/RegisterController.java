package com.example.demo.controller;

import com.example.demo.DTO.RegisterDTO;
import com.example.demo.DTO.RegisterResponse;
import com.example.demo.model.User;
import com.example.demo.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    JwtUserDetailsService jwtUserDetailService;

    @PostMapping
    public ResponseEntity<?> registerMember(@RequestBody RegisterDTO registerDTO){
        User newUser = new User();
        newUser.setNoHandphone(registerDTO.getPhoneNumber());
        newUser.setUserPin(registerDTO.getUserPin());
        newUser.setEmail(registerDTO.getUserEmail());
        newUser.setName(registerDTO.getName());
        newUser.setRole("user");

        jwtUserDetailService.save(newUser);
        RegisterResponse response = new RegisterResponse("Created", newUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
