package com.leiton.ejercicioLogin.exception;

public class EmailValidationException extends Exception{
    public EmailValidationException(){
        super("Wrong format for email");
    }
}
