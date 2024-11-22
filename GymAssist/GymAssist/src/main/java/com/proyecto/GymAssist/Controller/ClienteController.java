package com.proyecto.GymAssist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.GymAssist.model.Cliente;
import com.proyecto.GymAssist.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @GetMapping
    public String listClientes(Model model) {
        model.addAttribute("clientes", clienteService.getAllClientes());
        return "clientes";
    }

    
    @PostMapping
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    
    @GetMapping("/edit/{id}")
    public String EditarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "EditarCliente"; 
        }
        return "redirect:/clientes";
    }

    
    @PostMapping("/update/{id}")
    public String updateCliente(@PathVariable Long id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    
    @GetMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes";
    }
}