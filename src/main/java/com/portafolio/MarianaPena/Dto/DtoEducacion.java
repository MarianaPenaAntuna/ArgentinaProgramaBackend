
package com.portafolio.MarianaPena.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoEducacion {

    @NotBlank
    private String lugar;
    @NotBlank
    private String curso;
    @NotBlank
    private String imagen;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;

    public DtoEducacion() {
    }
    
    public DtoEducacion(String lugar, String curso, String imagen, String fecha, String descripcion) {
        this.lugar = lugar;
        this.curso = curso;
        this.imagen = imagen;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}