package com.web.Agenda.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user;
    private String titulo;
    private String notas;
    private String fecha;
    

    public Nota() {
    }

    
    
    public Nota(Integer user, String titulo, String fecha, String notas) {
        this.user = user;
        this.titulo = titulo;
        this.fecha = fecha;
        this.notas = notas;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Nota{" + "titulo=" + titulo  + ", notas=" + notas + ", fecha=" + fecha+ ", id=" + id+ ", user=" + user+ '}';
    }

}
