package com.proyecto.GymAssist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.GymAssist.model.User;
import com.proyecto.GymAssist.service.PlanesService;
import com.proyecto.GymAssist.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        return userService.login(email, password)
                .map(user -> "redirect:/crear-gimnasio")
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid email or password");
                    return "login";
                });
    }

    @Autowired
    private PlanesService planesService;


    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String email,
                         @RequestParam String password, @RequestParam String confirmPassword,
                         Model model) {

         
    if (!planesService.Buscarplanemail(email)) { 
        model.addAttribute("error", "Este correo no está suscrito a ningún plan");
        return "signup";
    }

    
    if (!password.equals(confirmPassword)) {
        model.addAttribute("error", "Las contraseñas no coinciden");
        return "signup";
    }

    User user = new User();
    user.setUsername(username);
    user.setEmail(email);
    user.setPassword(password);

    
    userService.register(user);

   
    return "redirect:/login";
    }
}