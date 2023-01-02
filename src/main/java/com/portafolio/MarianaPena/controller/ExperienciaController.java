 
package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.Dto.DtoExperiencia;
import com.portafolio.MarianaPena.model.Experiencia;
import com.portafolio.MarianaPena.security.controller.Mensaje;
import com.portafolio.MarianaPena.service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin()
@RequestMapping("/experiencias")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Experiencia>> list(){
         List<Experiencia> list = experienciaService.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getLugar()))
            return new ResponseEntity(new Mensaje("el lugar laboral es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByLugar(dtoExp.getLugar()))
            return new ResponseEntity(new Mensaje("esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
       
            
            
        Experiencia experiencia = new Experiencia(dtoExp.getDescripcion(), 
                                                  dtoExp.getFecha(), 
                                                  dtoExp.getImagen(), 
                                                  dtoExp.getLugar(), 
                                                  dtoExp.getPuesto());
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody DtoExperiencia dtoExp){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByLugar(dtoExp.getLugar()) && experienciaService.getByLugar(dtoExp.getLugar()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExp.getLugar())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setFecha(dtoExp.getFecha());
        experiencia.setImagen(dtoExp.getImagen());
        experiencia.setLugar(dtoExp.getLugar());
        experiencia.setPuesto(dtoExp.getPuesto());
        experiencia.setDescripcion(dtoExp.getDescripcion());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    }
    
