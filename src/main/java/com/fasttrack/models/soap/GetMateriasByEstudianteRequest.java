package com.fasttrack.models.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getMateriasByEstudianteRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetMateriasByEstudianteRequest {
	

	
	@XmlElement(required=true)
	private Long idEstudiante;

	public Long getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	
	

}
