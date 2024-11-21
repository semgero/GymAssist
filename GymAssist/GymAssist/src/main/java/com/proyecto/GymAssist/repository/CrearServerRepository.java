package com.proyecto.GymAssist.repository;

import com.proyecto.GymAssist.model.CrearServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrearServerRepository extends JpaRepository<CrearServer, Long> {
}