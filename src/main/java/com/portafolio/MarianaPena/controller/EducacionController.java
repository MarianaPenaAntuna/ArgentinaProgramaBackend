
package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.Dto.DtoEducacion;
import com.portafolio.MarianaPena.model.Educacion;
import com.portafolio.MarianaPena.security.controller.Mensaje;
import com.portafolio.MarianaPena.service.EducacionService;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/educaciones")
public class EducacionController {

    @Autowired
    EducacionService educacionService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Educacion>> list(){
         List<Educacion> list = educacionService.list();
         return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')") 
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getLugar()))
            return new ResponseEntity(new Mensaje("el campo institución educativa es obligatoria"), HttpStatus.BAD_REQUEST);
        if(educacionService.existsByLugar(dtoEdu.getLugar()))
            return new ResponseEntity(new Mensaje("esa educación ya existe"), HttpStatus.BAD_REQUEST);
       
            
            
        Educacion educacion = new Educacion(dtoEdu.getLugar(), 
                                                  dtoEdu.getCurso(), 
                                                  dtoEdu.getImagen(), 
                                                  dtoEdu.getFecha(), 
                                                  dtoEdu.getDescripcion());
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')") 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody DtoEducacion dtoEdu){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        if(educacionService.existsByLugar(dtoEdu.getLugar()) && educacionService.getByLugar(dtoEdu.getLugar()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEdu.getLugar())) 
            return new ResponseEntity(new Mensaje("El nombre del curso es obligatorio"), HttpStatus.BAD_REQUEST);
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setFecha(dtoEdu.getFecha());
        educacion.setImagen(dtoEdu.getImagen());
        educacion.setLugar(dtoEdu.getLugar());
        educacion.setCurso(dtoEdu.getCurso());
        educacion.setDescripcion(dtoEdu.getDescripcion());
        
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
    //@PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    }
    
