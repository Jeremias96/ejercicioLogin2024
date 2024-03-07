package com.leiton.ejercicioLogin.exception;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(){
        super("User is already registered");
    }
}
