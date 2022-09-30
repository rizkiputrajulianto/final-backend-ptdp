package com.example.demo.controller;

import com.example.demo.DTO.JwtResponse;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.config.JwtTokenUtil;
import com.example.demo.model.User;
import com.example.demo.service.JwtUserDetailsService;
import com.example.demo.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(maxAge = -1)
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserServices userServices;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;


    @PostMapping
    public ResponseEntity<?> userLogin(@RequestBody LoginDTO userLogin) throws Exception{
        System.out.println(userLogin);
        authenticate(userLogin.getPhoneNumber(), userLogin.getUserPin());

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(userLogin.getPhoneNumber());
        final String token = jwtTokenUtil.generateToken(userDetails);

        if(token == null){
            return new ResponseEntity<>(new JwtResponse(token, "Gagal Login"), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new JwtResponse(token, "Berhasil Login"), HttpStatus.OK);
        }
    }

    public void authenticate(String phoneNumber, String pinUser) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phoneNumber, pinUser));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
