package com.leiton.ejercicioLogin.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    
    private Instant timestamp;

    private Integer codigo;

    private String detail;
}
