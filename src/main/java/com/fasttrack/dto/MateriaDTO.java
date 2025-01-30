package com.fasttrack.dto;

import com.fasttrack.validations.NotExistsByNombre;

import jakarta.validation.constraints.NotBlank;

public class MateriaDTO {

	
	@NotBlank(message="El nombre es requerido")
	@NotExistsByNombre
	private String nombre;

	public MateriaDTO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
