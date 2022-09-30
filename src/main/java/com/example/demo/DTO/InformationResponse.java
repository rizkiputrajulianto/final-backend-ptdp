package com.example.demo.DTO;

import com.example.demo.model.Transaksi;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InformationResponse {
    String message;
    List<Transaksi> data;
}
