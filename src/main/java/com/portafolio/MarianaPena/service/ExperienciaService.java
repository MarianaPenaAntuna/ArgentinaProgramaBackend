
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Experiencia;
import com.portafolio.MarianaPena.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository expRepository;
    
    public List<Experiencia> list(){
        return expRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return expRepository.findById(id);
    }
    
    public Optional<Experiencia> getByLugar(String lugar){
        return expRepository.findByLugar(lugar);
    }
    
    public void save(Experiencia exp){
        expRepository.save(exp);
    }
    
    public void delete(int id){
        expRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return expRepository.existsById(id);
    }
    
    public boolean existsByLugar (String lugar){
        return expRepository.existsByLugar(lugar);
    }
       
}
