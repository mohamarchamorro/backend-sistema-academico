package com.fasttrack.models;

public class Pais {

	private Long id;
	private String nombre;
	private String codigo_iso_2;
	
	public Pais(Long id, String nombre, String codigo_iso_2) {
		this.id = id;
		this.nombre = nombre;
		this.codigo_iso_2 = codigo_iso_2;
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

	public String getCodigo_iso_2() {
		return codigo_iso_2;
	}

	public void setCodigo_iso_2(String codigo_iso_2) {
		this.codigo_iso_2 = codigo_iso_2;
	}
	
	
	
}
