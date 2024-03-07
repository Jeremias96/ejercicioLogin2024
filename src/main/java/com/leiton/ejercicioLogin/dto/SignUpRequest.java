package com.leiton.ejercicioLogin.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    
    private String name;

    private String email;

    private String password;

    private List<PhoneDTO> phones;
}
