package com.example.demo.controller;


import com.example.demo.DTO.ErrorResponse;
import com.example.demo.DTO.InformationResponse;
import com.example.demo.DTO.PaymentDTO;
import com.example.demo.DTO.PaymentResponse;
import com.example.demo.model.Transaksi;
import com.example.demo.service.TransaksiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    TransaksiServices transaksiServices;

    @PostMapping
    public ResponseEntity<?> payCard(@RequestBody PaymentDTO paymentDTO){
        PaymentResponse result = transaksiServices.payCard(paymentDTO);
        if(result == null){
            return new ResponseEntity<>(new ErrorResponse("Transaksi Gagal"), HttpStatus.NOT_FOUND);
        }else if(result.getSaldoSisa() < 0){
            return new ResponseEntity<>(new ErrorResponse("Saldo Tidak Mencukupi"), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTransaction(){
        List<Transaksi> dataTransaksi = transaksiServices.getAllTransactions();
        InformationResponse data = new InformationResponse("Sukses", dataTransaksi);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
