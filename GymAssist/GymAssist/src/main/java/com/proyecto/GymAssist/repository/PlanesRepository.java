package com.proyecto.GymAssist.repository;

import com.proyecto.GymAssist.model.Planes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanesRepository extends JpaRepository<Planes, Long> {
    public Planes findByEmail(String email);

}