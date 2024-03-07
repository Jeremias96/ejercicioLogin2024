package com.leiton.ejercicioLogin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiton.ejercicioLogin.entity.PhoneEntity;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Integer>{
    
}
