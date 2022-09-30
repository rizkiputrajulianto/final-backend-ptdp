package com.example.demo.DAO;

import com.example.demo.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiDAO extends JpaRepository<Transaksi, Long> {
}
