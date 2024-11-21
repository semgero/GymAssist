package com.proyecto.GymAssist.Controller;

import com.proyecto.GymAssist.model.Cliente;
import com.proyecto.GymAssist.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Página principal de clientes
    @GetMapping
    public String listClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "clientes";
    }

    // Guardar nuevo cliente
    @PostMapping
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    // Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String EditarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "EditarCliente"; // Plantilla para editar cliente
        }
        return "redirect:/clientes";
    }

    // Actualizar cliente
    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    // Eliminar cliente
    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes";
    }
}