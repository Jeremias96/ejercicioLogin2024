package com.leiton.ejercicioLogin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.leiton.ejercicioLogin.dto.LoginResponse;
import com.leiton.ejercicioLogin.dto.SignUpRequest;
import com.leiton.ejercicioLogin.dto.SignUpResponse;
import com.leiton.ejercicioLogin.entity.UserEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = PhoneMapper.class)
public interface UserMapper{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "modifiedDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "lastLogin", expression = "java(java.time.Instant.now())")
    @Mapping(target = "token", expression = "java(com.leiton.ejercicioLogin.utils.JwtUtils.createJwt(signUpRequest.getEmail()))")
    @Mapping(target = "isActive", constant = "true")
    UserEntity map(SignUpRequest signUpRequest);

    @Mapping(target = "id", expression = "java(java.util.UUID.fromString(userEntity.getId()))")
    @Mapping(target = "created", source = "createdDate")
    @Mapping(target = "modified", source = "modifiedDate")
    SignUpResponse map(UserEntity userEntity);

    @Mapping(target = "created", source = "createdDate")
    @Mapping(target = "modified", source = "modifiedDate")
    LoginResponse mapToLoginResponse(UserEntity userEntity);
}
