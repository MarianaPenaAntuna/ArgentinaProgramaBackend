
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Educacion;
import com.portafolio.MarianaPena.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService{
    @Autowired
    EducacionRepository eduRepository;
    
    public List<Educacion> list(){
        return eduRepository.findAll();
    }
     
    public Optional<Educacion> getOne(int id){
        return eduRepository.findById(id);
    }
    
    public Optional<Educacion> getByLugar(String lugar){
        return eduRepository.findByLugar(lugar);
    }
    
    public void save(Educacion edu){
        eduRepository.save(edu);
    }
    
    public void delete(int id){
        eduRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return eduRepository.existsById(id);
    }
    
    public boolean existsByLugar (String lugar){
        return eduRepository.existsByLugar(lugar);
    }
       
}
