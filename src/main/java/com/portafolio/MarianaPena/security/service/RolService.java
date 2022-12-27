
package com.portafolio.MarianaPena.security.service;

import com.portafolio.MarianaPena.security.entity.Rol;
import com.portafolio.MarianaPena.security.enums.RolNombre;
import com.portafolio.MarianaPena.security.repository.iRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        irolRepository.save(rol);
    }

    
}