
package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.Dto.DtoProyecto;
import com.portafolio.MarianaPena.model.Proyecto;
import com.portafolio.MarianaPena.security.controller.Mensaje;
import com.portafolio.MarianaPena.service.ProyectoService;
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
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProy) {
        if (StringUtils.isBlank(dtoProy.getNombre())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (proyectoService.existsByNombre(dtoProy.getNombre())) {
            return new ResponseEntity(new Mensaje("esa nombre de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoProy.getNombre(),
                dtoProy.getFecha(),
                dtoProy.getLink(),
                dtoProy.getDescripcion());
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProy) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (proyectoService.existsByNombre(dtoProy.getNombre()) && proyectoService.getByNombre(dtoProy.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese `proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProy.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setNombre(dtoProy.getNombre());
        proyecto.setFecha(dtoProy.getFecha());
        proyecto.setLink(dtoProy.getLink());
        proyecto.setDescripcion(dtoProy.getDescripcion());

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Datos del proyecto actualizados"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }

}
