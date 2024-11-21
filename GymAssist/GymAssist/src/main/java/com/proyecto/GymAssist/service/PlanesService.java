package com.proyecto.GymAssist.service;

import com.proyecto.GymAssist.model.Planes;
import com.proyecto.GymAssist.repository.PlanesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanesService {

    @Autowired
    private PlanesRepository planesRepository;
    
    /*
    public Planes Buscarplanemail(String email){
        return planesRepository.findByEmail(email);
    } */

    public boolean Buscarplanemail(String email) {
    
    Planes plan = planesRepository.findByEmail(email); 
    return plan != null; 
}

}
