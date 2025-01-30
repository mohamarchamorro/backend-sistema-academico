package com.fasttrack.models;

public class Estudiante {

	private Long id;
	private String primer_nombre;
	private String primer_apellido;
	private Long id_pais;
	private String correo_electronico;
	
	
	
	public Estudiante() {
	}



	public Estudiante(Long id, String primer_nombre, String primer_apellido, Long id_pais, String correo_electronico) {
		this.id = id;
		this.primer_nombre = primer_nombre;
		this.primer_apellido = primer_apellido;
		this.id_pais = id_pais;
		this.correo_electronico = correo_electronico;
	}
	
	

	public Estudiante(String primer_nombre, String primer_apellido, Long id_pais, String correo_electronico) {
		this.primer_nombre = primer_nombre;
		this.primer_apellido = primer_apellido;
		this.id_pais = id_pais;
		this.correo_electronico = correo_electronico;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public Long getId_pais() {
		return id_pais;
	}

	public void setId_pais(Long id_pais) {
		this.id_pais = id_pais;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	
	
	
	
}
