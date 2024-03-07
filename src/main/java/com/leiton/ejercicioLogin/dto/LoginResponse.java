package com.leiton.ejercicioLogin.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    
    private String id;

    private Instant created;

    private Instant modified;

    @JsonProperty("last_login")
    private Instant lastLogin;

    private String token;

    @JsonProperty("isactive")
    private Boolean isActive;

    private String name;

    private String email;

    private String password;

    private List<PhoneDTO> phones;
}
