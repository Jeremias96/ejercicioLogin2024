package com.leiton.ejercicioLogin.exception;

public class PasswordValidationException extends Exception{
    public PasswordValidationException(){
        super("Password should contain one capital letter, two numbers and between 8 and 12 characters");
    }
}
