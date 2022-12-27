
package com.portafolio.MarianaPena.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Proyecto  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String fecha;
    private String link;
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(String nombre, String fecha, String link, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.link = link;
        this.descripcion = descripcion;
    }
   
}