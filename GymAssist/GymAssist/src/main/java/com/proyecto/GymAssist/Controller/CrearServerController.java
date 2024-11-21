package com.proyecto.GymAssist.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.GymAssist.model.CrearServer;
import com.proyecto.GymAssist.service.CrearServerService;

@Controller // Cambia RestController a Controller
@RequestMapping("/gimnasios")
public class CrearServerController {

    @Autowired
    private CrearServerService servicio;

    
    @PostMapping
    public ResponseEntity<CrearServer> crearGimnasio(@RequestBody CrearServer gimnasio) {
        CrearServer nuevoGimnasio = servicio.crearGimnasio(gimnasio);
        return ResponseEntity.ok(nuevoGimnasio); 
    }

    
    @GetMapping
    public ResponseEntity<List<CrearServer>> listarGimnasios() {
        List<CrearServer> gimnasios = servicio.listarGimnasios();
        return ResponseEntity.ok(gimnasios);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CrearServer> obtenerGimnasio(@PathVariable Long id) {
        Optional<CrearServer> gimnasio = servicio.obtenerGimnasio(id);
        return gimnasio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGimnasio(@PathVariable Long id) {
        servicio.eliminarGimnasio(id);
        return ResponseEntity.noContent().build(); 
    }
}
