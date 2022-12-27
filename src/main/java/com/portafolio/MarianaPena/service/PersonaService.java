
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Persona;
import com.portafolio.MarianaPena.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService{
    @Autowired
    PersonaRepository persoRepository;
    
    public List<Persona> list(){
        return persoRepository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return persoRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return persoRepository.findByNombre(nombre);
    }
    
    public void save(Persona perso){
       persoRepository.save(perso);
    }
    
    public void delete(int id){
        persoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return persoRepository.existsById(id);
    }
    
    public boolean existsByNombre (String nombre){
        return persoRepository.existsByNombre(nombre);
    }
       
}

