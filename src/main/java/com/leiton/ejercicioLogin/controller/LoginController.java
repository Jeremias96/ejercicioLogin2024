package com.leiton.ejercicioLogin.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiton.ejercicioLogin.dto.ErrorMessage;
import com.leiton.ejercicioLogin.dto.LoginRequest;
import com.leiton.ejercicioLogin.dto.LoginResponse;
import com.leiton.ejercicioLogin.dto.SignUpRequest;
import com.leiton.ejercicioLogin.dto.SignUpResponse;
import com.leiton.ejercicioLogin.exception.EmailValidationException;
import com.leiton.ejercicioLogin.exception.PasswordValidationException;
import com.leiton.ejercicioLogin.exception.UserAlreadyExistsException;
import com.leiton.ejercicioLogin.exception.UserNotFoundException;
import com.leiton.ejercicioLogin.impl.LoginServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class LoginController {

    private final LoginServiceImpl loginService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        try {
            SignUpResponse response = loginService.signUp(signUpRequest);
            return new ResponseEntity<SignUpResponse>(response, HttpStatus.OK);
        } catch (EmailValidationException | UserAlreadyExistsException | GeneralSecurityException | UnsupportedEncodingException e) {
            return new ResponseEntity<ErrorMessage>(new ErrorMessage(Instant.now(), 400, e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (PasswordValidationException e) {
            return new ResponseEntity<ErrorMessage>(new ErrorMessage(Instant.now(), 401, e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
    
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse response = loginService.login(loginRequest);
            return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<ErrorMessage>(new ErrorMessage(Instant.now(), 404, e.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}