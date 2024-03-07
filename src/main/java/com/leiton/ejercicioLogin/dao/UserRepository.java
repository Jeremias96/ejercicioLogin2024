package com.leiton.ejercicioLogin.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiton.ejercicioLogin.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByToken(String token);
}
