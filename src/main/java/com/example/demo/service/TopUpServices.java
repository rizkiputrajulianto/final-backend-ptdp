package com.example.demo.service;

import com.example.demo.DTO.TopUpDTO;
import com.example.demo.DTO.TopUpResponse;

public interface TopUpServices {
    TopUpResponse userTopUp(TopUpDTO topUpDTO);
}
