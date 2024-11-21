package com.proyecto.GymAssist.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "numero_telefono", nullable = false, unique = true)
    private String numeroTelefono;

    @Column(name = "client_plan", nullable = false)
    private String clientPlan;
}