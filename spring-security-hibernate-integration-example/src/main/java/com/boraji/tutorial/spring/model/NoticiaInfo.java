package com.boraji.tutorial.spring.model;



public class NoticiaInfo {

	private String titulo;
	private String contenido;
	private String fecha;
	private int id;

	private boolean newNoticia = false;

	public NoticiaInfo() {
	}

	public NoticiaInfo(NoticiaInfo noticia) {
		this.id = noticia.getId();
		this.titulo = noticia.getTitulo();
		this.fecha = noticia.getFecha();
		this.contenido = noticia.getContenido();

	}

	public NoticiaInfo(int id, String titulo, String fecha, String contenido) {
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.contenido = contenido;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isNewNoticia() {
		return newNoticia;
	}

	public void setNewNoticia(boolean newNoticia) {
		this.newNoticia = newNoticia;
	}

}
