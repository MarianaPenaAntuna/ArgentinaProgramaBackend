
package com.portafolio.MarianaPena.repository;

import com.portafolio.MarianaPena.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository <Proyecto,Integer>{
    public Optional<Proyecto> findByNombre (String nombre);
    public boolean existsByNombre (String nombre);
}
