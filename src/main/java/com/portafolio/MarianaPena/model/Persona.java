
package com.portafolio.MarianaPena.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String imagen;
    private String descripcion;
    private String frase;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String imagen, String descripcion, String frase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.frase = frase;
    }
    
    
}