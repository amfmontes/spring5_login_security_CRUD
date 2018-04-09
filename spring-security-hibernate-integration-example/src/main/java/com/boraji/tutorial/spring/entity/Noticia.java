package com.boraji.tutorial.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "noticias")
public class Noticia implements Serializable{

	private static final long serialVersionUID = -1000119078147252957L;
	
	private int id;
	private String titulo;
	private String fecha;
	private String contenido;
	
	
	  // For sort.
    private Date createDate;
	
    
    public Noticia() {
    }
 
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    @Column(name = "titulo")
    public String getTitulo() {
        return titulo;
    }
 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    @Column(name = "fecha")
    public String getFecha() {
        return fecha;
    }
 
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    @Column(name = "contenido")
    public String getContenido() {
        return contenido;
    }
 
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
