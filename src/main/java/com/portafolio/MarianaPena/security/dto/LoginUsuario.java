
package com.portafolio.MarianaPena.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    
}