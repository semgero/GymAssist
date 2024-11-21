package com.proyecto.GymAssist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class paginasMapping {
    @GetMapping("/index")
    public String index() {
        return "index"; // Esto busca la plantilla en templates/index.html
    }

    @GetMapping("/planes")
    public String planes() {
        return "planes"; // Esto busca la plantilla en templates/planes.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Esto busca la plantilla en templates/login.html
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // Esto busca la plantilla en templates/signup.html
    }

    @GetMapping("/rutinas")
    public String rutinas() {
        return "rutinas";
    }

    @GetMapping("/pecho")
    public String pecho() {
        return "pecho"; // Esto busca la plantilla en templates/pecho.html
    }

    @GetMapping("/espalda")
    public String espalda() {
        return "espalda"; // Esto busca la plantilla en templates/espalda.html
    }

    @GetMapping("/bicep")
    public String bicep() {
        return "bicep"; // Esto busca la plantilla en templates/bicep.html
    }

    @GetMapping("/tricep")
    public String tricep() {
        return "tricep"; // Esto busca la plantilla en templates/tricep.html
    }

    @GetMapping("/femoral")
    public String femoral() {
        return "femoral"; // Esto busca la plantilla en templates/femoral.html
    }

    @GetMapping("/cuadricep")
    public String cuadricep() {
        return "cuadricep"; // Esto busca la plantilla en templates/cuadricep.html
    }

    @GetMapping("/crear-gimnasio")
    public String creargimnasio() {
        return "crear-gimnasio"; // Esto busca la plantilla en templates/crear-gimnasio.html
    }

    @GetMapping("/server")
    public String server() {
        return "server"; // Esto busca la plantilla en templates/server.html
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Esto busca la plantilla en templates/dashboard.html
    }

    @GetMapping("/pagos")
    public String pagos() {
        return "pagos"; // Esto busca la plantilla en templates/pagos.html
    }

    @GetMapping("/plan1")
    public String plan1() {
        return "plan1"; // Esto busca la plantilla en templates/plan1.html
    }

    @GetMapping("/plan2")
    public String plan2() {
        return "plan2"; // Esto busca la plantilla en templates/plan2.html
    }

    @GetMapping("/plan3")
    public String plan3() {
        return "plan3"; // Esto busca la plantilla en templates/plan3.html
    }

    @GetMapping("/configuracion")
    public String configuracion() {
        return "configuracion"; // Esto busca la plantilla en templates/configuracion.html
    }

    @GetMapping("/crearserver")
    public String crearserver() {
        return "crearserver"; // Esto busca la plantilla en templates/crearserver.html
    }

}
