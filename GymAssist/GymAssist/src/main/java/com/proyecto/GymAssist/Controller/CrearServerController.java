package com.proyecto.GymAssist.Controller;

import com.proyecto.GymAssist.model.CrearServer;
import com.proyecto.GymAssist.repository.CrearServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gimnasios")
public class CrearServerController {

    @Autowired
    private CrearServerRepository crearServerRepository;

    @GetMapping
    public String listarGimnasios(Model model) {
        model.addAttribute("gimnasios", crearServerRepository.findAll());
        return "listar-gimnasios"; // Página HTML para mostrar la lista de gimnasios
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrearGimnasio() {
        return "crearserver"; // Nombre del archivo HTML que has proporcionado
    }

    @PostMapping
    public String crearGimnasio(@ModelAttribute CrearServer crearServer) {
        crearServerRepository.save(crearServer);
        return "redirect:/clientes";
    }
}
