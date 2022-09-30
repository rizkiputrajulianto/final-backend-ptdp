package com.example.demo.service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.DTO.TopUpDTO;
import com.example.demo.DTO.TopUpResponse;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopUpServicesImpl implements TopUpServices{
    @Autowired
    UserDAO userDAO;


    @Override
    public TopUpResponse userTopUp(TopUpDTO topUpDTO) {
        User findUser = userDAO.findByNoHandphone(topUpDTO.getPhoneNumber());
        findUser.setSaldo(findUser.getSaldo() + topUpDTO.getNominal());
        userDAO.save(findUser);
        return new TopUpResponse("Sukses Top Up Saldo", findUser.getSaldo());
    }
}
