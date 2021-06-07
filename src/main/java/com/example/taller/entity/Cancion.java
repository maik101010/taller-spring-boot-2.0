package com.example.taller.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 150, nullable = false)
    private String autor;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    public Cancion() {
    }

    public Cancion(Long id, String nombre, String autor, LocalDate fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
