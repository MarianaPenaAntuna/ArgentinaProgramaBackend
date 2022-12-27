
package com.portafolio.MarianaPena.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProyecto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String fecha;
    @NotBlank
    private String link;
    @NotBlank
    private String descripcion;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombre, String fecha, String link, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.link = link;
        this.descripcion = descripcion;
    }
   
}