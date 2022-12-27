
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Proyecto;
import com.portafolio.MarianaPena.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectoService{
    @Autowired
    ProyectoRepository proyRepository;

    public List<Proyecto> list(){
        return proyRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return proyRepository.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre){
        return proyRepository.findByNombre(nombre);
    }
    
    public void save(Proyecto proy){
       proyRepository.save(proy);
    }
    
    public void delete(int id){
        proyRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyRepository.existsById(id);
    }
    
    public boolean existsByNombre (String nombre){
        return proyRepository.existsByNombre(nombre);
    }
       
}