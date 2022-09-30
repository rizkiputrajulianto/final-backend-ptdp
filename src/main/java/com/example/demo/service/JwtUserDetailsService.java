package com.example.demo.service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByNoHandphone(username);
        if(user == null){
            throw new UsernameNotFoundException("User dengan Nomor Handphone "+ username +" Tidak Ditemukan ");
        }

        return new org.springframework.security.core.userdetails.User(user.getNoHandphone(), user.getUserPin(), new ArrayList<>());
    }

    public User save(User user){
        user.setUserPin(passwordEncoder().encode(user.getUserPin()));
        return userDAO.save(user);
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


