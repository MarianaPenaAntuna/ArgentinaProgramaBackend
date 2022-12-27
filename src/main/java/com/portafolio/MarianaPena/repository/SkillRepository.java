
package com.portafolio.MarianaPena.repository;

import com.portafolio.MarianaPena.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository <Skill, Integer>{
    public Optional<Skill> findByNombre (String nombre);
    public boolean existsByNombre (String nombre);
}