package com.example.demo.service;

import com.example.demo.DTO.PaymentDTO;
import com.example.demo.DTO.PaymentResponse;
import com.example.demo.model.Transaksi;

import java.util.List;

public interface TransaksiServices {
    PaymentResponse payCard(PaymentDTO paymentDTO);
    List<Transaksi> getAllTransactions();


}
