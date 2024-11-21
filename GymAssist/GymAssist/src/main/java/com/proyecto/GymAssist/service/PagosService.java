package com.proyecto.GymAssist.service;

import com.proyecto.GymAssist.model.CrearServer;
import com.proyecto.GymAssist.repository.CrearServerRepository;
import com.proyecto.GymAssist.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosService {

    @Autowired
    private CrearServerRepository crearServerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para calcular el total recaudado
    public Double calcularTotalRecaudado() {
        // Obtener el precio de la mensualidad del primer gimnasio registrado
        List<CrearServer> gimnasios = crearServerRepository.findAll();
        if (gimnasios.isEmpty()) {
            return 0.0; // Si no hay gimnasios registrados, retorna 0
        }
        CrearServer gimnasio = gimnasios.get(0); // Asumimos que solo hay un gimnasio creado

        double mensualidad = gimnasio.getPrecio();

        // Contar el total de clientes registrados (activos y retirados)
        long numeroDeClientes = clienteRepository.count();

        // Calcular el total recaudado
        double totalRecaudado = mensualidad * numeroDeClientes;

        return totalRecaudado;
    }
}
