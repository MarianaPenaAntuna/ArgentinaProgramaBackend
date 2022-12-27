
package com.portafolio.MarianaPena.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String lugar;
    @NotBlank
    private String puesto;
    @NotBlank
    private String imagen;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;

    public DtoExperiencia() {
    }
    
    public DtoExperiencia(String lugar, String puesto, String imagen, String fecha, String descripcion) {
        this.lugar = lugar;
        this.puesto = puesto;
        this.imagen = imagen;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
    
    
    
}
