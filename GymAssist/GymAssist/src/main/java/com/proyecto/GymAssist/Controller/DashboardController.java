package com.proyecto.GymAssist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.GymAssist.service.ClienteService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final ClienteService clienteService;

    public DashboardController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String getDashboard(Model model) {
        model.addAttribute("usuariosActivos", clienteService.getUsuariosActivos());
        model.addAttribute("usuariosRetirados", clienteService.getUsuariosRetirados());
        model.addAttribute("usuariosTotales", clienteService.getUsuariosTotales());
        return "dashboard"; 
    }
}
