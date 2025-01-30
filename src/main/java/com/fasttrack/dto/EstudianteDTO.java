package com.fasttrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class EstudianteDTO {
	

    @NotBlank(message = "El primer nombre es requerido")
    @Pattern(regexp = "^[A-Z]{1,30}$", message = "El primer nombre solo permite letras mayúsculas sin acentos ni espacios (máximo 30 caracteres)")
    private String primer_nombre;
    

    @NotBlank(message = "El primer apellido es requerido")
    @Pattern(regexp = "^[A-Z]{1,30}$", message = "El primer apellido solo permite letras mayúsculas sin acentos ni espacios (máximo 30 caracteres)")
	private String primer_apellido;
    
    @NotNull(message = "El ID del país no puede ser nulo")
    private Long id_pais;
	
	public EstudianteDTO(String primer_nombre, String primer_apellido, Long id_pais) {
		this.primer_nombre = primer_nombre;
		this.primer_apellido = primer_apellido;
		this.id_pais = id_pais;
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


	
}
