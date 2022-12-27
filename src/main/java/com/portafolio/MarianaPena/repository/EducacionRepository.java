
package com.portafolio.MarianaPena.repository;

import com.portafolio.MarianaPena.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository <Educacion,Integer>{
    public Optional<Educacion> findByLugar (String lugar);
    public boolean existsByLugar (String lugar);
}
