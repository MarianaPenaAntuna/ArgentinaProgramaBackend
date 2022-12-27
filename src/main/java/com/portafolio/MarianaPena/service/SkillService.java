
package com.portafolio.MarianaPena.service;

import com.portafolio.MarianaPena.model.Skill;
import com.portafolio.MarianaPena.repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillService{
    @Autowired
    private SkillRepository skRepository;
    
    public List<Skill> list(){
        return skRepository.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return skRepository.findById(id);
    }
    
    public Optional<Skill> getByNombre(String nombre){
        return skRepository.findByNombre(nombre);
    }
    
    public void save(Skill skill){
       skRepository.save(skill);
    }
    
    public void delete(int id){
        skRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skRepository.existsById(id);
    }
    
    public boolean existsByNombre (String nombre){
        return skRepository.existsByNombre(nombre);
    }
       
}


    
