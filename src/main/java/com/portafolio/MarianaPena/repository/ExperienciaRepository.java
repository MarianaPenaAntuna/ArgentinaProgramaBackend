
package com.portafolio.MarianaPena.repository;

import com.portafolio.MarianaPena.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Integer>{
    public Optional<Experiencia> findByLugar (String lugar);
    public boolean existsByLugar (String lugar);
}

