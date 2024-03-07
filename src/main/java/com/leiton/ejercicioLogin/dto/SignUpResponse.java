package com.leiton.ejercicioLogin.dto;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpResponse {

    private UUID id;

    private Instant created;

    private Instant modified;

    @JsonProperty("last_login")
    private Instant lastLogin;

    private String token;

    @JsonProperty("isactive")
    private Boolean isActive;
}
