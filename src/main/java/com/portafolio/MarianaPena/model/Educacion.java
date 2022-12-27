
package com.portafolio.MarianaPena.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Educacion{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String lugar;
    private String curso;
    private String imagen;
    private String fecha;
    private String descripcion;

    public Educacion() {
    }

    public Educacion(String lugar, String curso, String imagen, String fecha, String descripcion) {
        this.lugar = lugar;
        this.curso = curso;
        this.imagen = imagen;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

   
    
    
}
