package com.proyecto.GymAssist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.GymAssist.model.CrearServer;
import com.proyecto.GymAssist.repository.ClienteRepository;
import com.proyecto.GymAssist.repository.CrearServerRepository;

@Service
public class PagosService {

    @Autowired
    private CrearServerRepository crearServerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    
    public Double calcularTotalRecaudado() {
        
        List<CrearServer> gimnasios = crearServerRepository.findAll();
        if (gimnasios.isEmpty()) {
            return 0.0; 
        }
        CrearServer gimnasio = gimnasios.get(0); 

        double mensualidad = gimnasio.getPrecio();

        
        long numeroDeClientes = clienteRepository.count();

        
        double totalRecaudado = mensualidad * numeroDeClientes;

        return totalRecaudado;
    }
}
