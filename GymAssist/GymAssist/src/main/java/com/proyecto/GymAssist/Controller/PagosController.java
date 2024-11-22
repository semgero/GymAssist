package com.proyecto.GymAssist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.GymAssist.model.Cliente;
import com.proyecto.GymAssist.repository.ClienteRepository;
import com.proyecto.GymAssist.service.PagosService;

@Controller
public class PagosController {

    @Autowired
    private PagosService pagosService;

    @Autowired
    private ClienteRepository clienteRepository;  
    @GetMapping("/pagos")
    public String mostrarPagos(Model model) {
        
        double totalRecaudado = pagosService.calcularTotalRecaudado();
        List<Cliente> clientes = clienteRepository.findAll();

       
        model.addAttribute("totalRecaudado", totalRecaudado);
        model.addAttribute("clientes", clientes);

        return "pagos"; 
    }
}
