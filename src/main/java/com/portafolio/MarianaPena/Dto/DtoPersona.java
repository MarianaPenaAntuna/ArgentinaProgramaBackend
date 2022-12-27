package com.portafolio.MarianaPena.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String imagen;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String frase;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String imagen, String descripcion, String frase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.frase = frase;
    }

}
