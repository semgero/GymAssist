package com.proyecto.GymAssist.service;

import com.proyecto.GymAssist.model.Cliente;
import com.proyecto.GymAssist.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private int usuariosRetirados = 0; // Contador para usuarios retirados

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            usuariosRetirados++;
        }
    }

    public int getUsuariosActivos() {
        return (int) clienteRepository.count();
    }

    public int getUsuariosRetirados() {
        return usuariosRetirados;
    }

    public int getUsuariosTotales() {
        return getUsuariosActivos() + getUsuariosRetirados();
    }
}