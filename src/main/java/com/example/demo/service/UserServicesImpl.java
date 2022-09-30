package com.example.demo.service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.RegisterDTO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    UserDAO userDao;

    @Override
    public User register(RegisterDTO registerDTO) {
        User newUser = new User();
        newUser.setName(registerDTO.getName());
        newUser.setNoHandphone(registerDTO.getPhoneNumber());
        newUser.setUserPin(registerDTO.getUserPin());
        newUser.setEmail(registerDTO.getUserEmail());
        return userDao.save(newUser);
    }

    @Override
    public User login(LoginDTO loginDTO) {
        User findData = userDao.findByNoHandphone(loginDTO.getPhoneNumber());

        if(Objects.equals(loginDTO.getUserPin(), findData.getUserPin())){
            return findData;
        }else{
            return findData;
        }
    }
}
