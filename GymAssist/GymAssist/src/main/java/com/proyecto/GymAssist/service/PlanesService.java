package com.proyecto.GymAssist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.GymAssist.model.Planes;
import com.proyecto.GymAssist.repository.PlanesRepository;


@Service
public class PlanesService {

    @Autowired
    private PlanesRepository planesRepository;
    


    public boolean Buscarplanemail(String email) {
    
    Planes plan = planesRepository.findByEmail(email); 
    return plan != null; 
}

}
