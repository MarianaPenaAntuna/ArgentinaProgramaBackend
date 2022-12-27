
package com.portafolio.MarianaPena.security.repository;

import com.portafolio.MarianaPena.security.entity.Rol;
import com.portafolio.MarianaPena.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
