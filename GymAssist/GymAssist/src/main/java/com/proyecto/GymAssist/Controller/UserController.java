package com.proyecto.GymAssist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.GymAssist.model.User;
import com.proyecto.GymAssist.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/configuracion/cambiar-contrasena")
    public String updatePassword(@RequestParam String email,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 Model model) {
        
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden.");
            return "configuracion";  
        }

       
        User user = userService.findUserByEmail(email);

       
        if (user == null) {
            model.addAttribute("error", "No se encontró un usuario con ese correo.");
            return "configuracion"; 
        }

        
        user.setPassword(newPassword); 
        userService.updateUser(user);

        model.addAttribute("success", "Contraseña actualizada correctamente.");
        return "configuracion";  
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        return userService.login(email, password)
                .map(user -> "redirect:/crear-gimnasio")
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid email or password");
                    return "login";
                });
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String email,
                         @RequestParam String password, @RequestParam String confirmPassword,
                         Model model) {

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
