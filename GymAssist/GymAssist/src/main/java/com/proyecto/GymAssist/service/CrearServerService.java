package com.proyecto.GymAssist.service;

import com.proyecto.GymAssist.model.CrearServer;
import com.proyecto.GymAssist.repository.CrearServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrearServerService {

    @Autowired
    private CrearServerRepository repository;

    // Crear un nuevo gimnasio
    public CrearServer crearGimnasio(CrearServer gimnasio) {
        return repository.save(gimnasio);
    }

    // Listar todos los gimnasios
    public List<CrearServer> listarGimnasios() {
        return repository.findAll();
    }

    // Obtener gimnasio por ID
    public Optional<CrearServer> obtenerGimnasio(Long id) {
        return repository.findById(id);
    }

    // Eliminar un gimnasio
    public void eliminarGimnasio(Long id) {
        repository.deleteById(id);
    }
}
