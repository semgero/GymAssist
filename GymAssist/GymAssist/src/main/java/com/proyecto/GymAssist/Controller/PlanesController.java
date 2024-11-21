package com.proyecto.GymAssist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.GymAssist.model.Planes;
import com.proyecto.GymAssist.repository.PlanesRepository;


@Controller
@RequestMapping("/planes")
public class PlanesController {

    @Autowired
    private PlanesRepository planesRepository;

    @PostMapping("/form")
    public String processForm(
            @ModelAttribute Planes planes,
            @RequestParam("planType") String planType,
            Model model
    ) {
        planes.setPlanType(planType);
        planesRepository.save(planes);
        model.addAttribute("message", "Pago recibido correctamente para el plan: " + planType);
        return "signup";
    }

    
}
