package com.portafolio.MarianaPena.controller;

import com.portafolio.MarianaPena.Dto.DtoSkill;
import com.portafolio.MarianaPena.model.Proyecto;
import com.portafolio.MarianaPena.model.Skill;
import com.portafolio.MarianaPena.security.controller.Mensaje;
import com.portafolio.MarianaPena.service.SkillService;
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
@RequestMapping("/skills")
public class SkillController {

        @Autowired
        SkillService skillService;

        @GetMapping("/lista")
        public ResponseEntity<List<Skill>> list() {
            List<Skill> list = skillService.list();
            return new ResponseEntity(list, HttpStatus.OK);
        }

        //@PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/create")
        public ResponseEntity<?> create(@RequestBody DtoSkill dtoSk) {
            if (StringUtils.isBlank(dtoSk.getNombre())) {
                return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            }
            if (skillService.existsByNombre(dtoSk.getNombre())) {
                return new ResponseEntity(new Mensaje("esa skill ya existe"), HttpStatus.BAD_REQUEST);
            }

            Skill skill = new Skill(dtoSk.getNombre(),
                    dtoSk.getPorcentaje());
            skillService.save(skill);
            return new ResponseEntity(new Mensaje("Skill agregads"), HttpStatus.OK);
        }

        @GetMapping("/detail/{id}")
        public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
            if (!skillService.existsById(id)) {
                return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.NOT_FOUND);
            }
            Skill skill = skillService.getOne(id).get();
            return new ResponseEntity(skill, HttpStatus.OK);
        }

        //@PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSk) {
            if (!skillService.existsById(id)) {
                return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
            }
            if (skillService.existsByNombre(dtoSk.getNombre()) && skillService.getByNombre(dtoSk.getNombre()).get().getId() != id) {
                return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
            }
            if (StringUtils.isBlank(dtoSk.getNombre())) {
                return new ResponseEntity(new Mensaje("El nombre de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
            }
            Skill skill = skillService.getOne(id).get();
            skill.setNombre(dtoSk.getNombre());
            skill.setPorcentaje(dtoSk.getPorcentaje());

            skillService.save(skill);
            return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
        }

        //@PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            if (!skillService.existsById(id)) {
                return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
            }
            skillService.delete(id);
            return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
        }

    }
