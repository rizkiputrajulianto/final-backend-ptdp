package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "nama")
    private String name;
    @NotNull
    @Column(name = "phoneNumber", unique = true)
    private String noHandphone;
    @NotNull
    @Column(name = "pin")
    private String userPin;
    @NotNull
    @Column(name = "userEmail", unique = true)
    private String email;
    @NotNull
    private int saldo;
    @NotNull
    private String role;

    private String noKartu;

    private String jenisKartu;
}
