package com.example.demo.controller;

import com.example.demo.DTO.TopUpDTO;
import com.example.demo.service.TopUpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topup")
public class TopUpController {

    @Autowired
    TopUpServices topUpServices;

    @PostMapping
    public ResponseEntity<?> addSaldo(@RequestBody TopUpDTO topUpDTO){
        return new ResponseEntity<>(topUpServices.userTopUp(topUpDTO), HttpStatus.OK);
    }
}
