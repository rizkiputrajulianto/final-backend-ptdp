package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    String noKartuETol;
    @NotNull
    int nominal;
    @NotNull
    Date tanggalPembayaran;
    @NotNull
    String statusTransaksi;

    String noReferensi;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
            @JoinColumn(name = "user_id", nullable = false)
            @OnDelete(action = OnDeleteAction.CASCADE)
            @JsonIgnore
    User users;
}
