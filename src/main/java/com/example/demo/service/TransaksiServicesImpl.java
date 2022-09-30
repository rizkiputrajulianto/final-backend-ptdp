package com.example.demo.service;

import com.example.demo.DAO.TransaksiDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.DTO.PaymentDTO;
import com.example.demo.DTO.PaymentResponse;
import com.example.demo.model.Transaksi;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TransaksiServicesImpl implements TransaksiServices{
    @Autowired
    TransaksiDAO transaksiDAO;

    @Autowired
    UserDAO userDAO;

    @Override
    public PaymentResponse payCard(PaymentDTO paymentDTO) {
        PaymentResponse result = new PaymentResponse();
        try{
            User payUser = userDAO.findByNoHandphone(paymentDTO.getUserNoHandpone());
            int saldo = payUser.getSaldo() - paymentDTO.getNominal();
            if (saldo < 0){
                result.setSaldoSisa(-1);
                return result;
            }
            payUser.setSaldo(saldo);
            Transaksi submitPayment = new Transaksi();
            submitPayment.setNoKartuETol(paymentDTO.getNoKartuETol());
            submitPayment.setNominal(paymentDTO.getNominal());
            submitPayment.setUsers(payUser);
            submitPayment.setTanggalPembayaran(new Date());
            userDAO.save(payUser);
            transaksiDAO.save(submitPayment);
            result.setStatus("Sukses");
            result.setMessage("Berhasil Melakukan Pembayaran");
            result.setSaldoSisa(payUser.getSaldo());
            return result;
        }catch(Exception e){
            result.setStatus(e.toString());
            return result;
        }
    }

    public List<Transaksi> getAllTransactions(){
        return transaksiDAO.findAll();
    }
}
