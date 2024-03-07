package com.leiton.ejercicioLogin.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import com.leiton.ejercicioLogin.dto.LoginRequest;
import com.leiton.ejercicioLogin.dto.LoginResponse;
import com.leiton.ejercicioLogin.dto.SignUpRequest;
import com.leiton.ejercicioLogin.dto.SignUpResponse;
import com.leiton.ejercicioLogin.exception.EmailValidationException;
import com.leiton.ejercicioLogin.exception.PasswordValidationException;
import com.leiton.ejercicioLogin.exception.UserAlreadyExistsException;
import com.leiton.ejercicioLogin.exception.UserNotFoundException;

public interface LoginService {
    
    public SignUpResponse signUp(SignUpRequest signUpRequest) throws EmailValidationException, PasswordValidationException, 
        GeneralSecurityException, UnsupportedEncodingException, UserAlreadyExistsException;

    public LoginResponse login(LoginRequest loginRequest) throws UserNotFoundException;
}
