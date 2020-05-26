
package com.emergentes.modelo;

import java.sql.Date;

public class blog {
    private int id;
    private int id_entrada;
    private String fecha;
    private String  titulo;
    private String comentario;

    public blog() {
        this.id = 0;
        this.id_entrada = 0;
        this.fecha = "";
        this.titulo = "";
        this.comentario = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

   
    
    
}
