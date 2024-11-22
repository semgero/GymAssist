package com.proyecto.GymAssist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.GymAssist.model.CrearServer;
import com.proyecto.GymAssist.repository.CrearServerRepository;

@Service
public class CrearServerService {

    @Autowired
    private CrearServerRepository repository;

    
    public CrearServer crearGimnasio(CrearServer gimnasio) {
        return repository.save(gimnasio);
    }

    
    public List<CrearServer> listarGimnasios() {
        return repository.findAll();
    }

    
    public Optional<CrearServer> obtenerGimnasio(Long id) {
        return repository.findById(id);
    }

    
   
}
