package com.fasttrack.models.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matricula", propOrder = {
    "estudiante",
    "materia"
})

public class MatriculaSOAP {

	@XmlElement(name = "estudiante",required = true)
	private EstudianteSOAP estudiante;
	
	@XmlElement(name = "materia",required = true)
	private MateriaSOAP materia;

	public MatriculaSOAP(EstudianteSOAP estudiante, MateriaSOAP materia) {
		this.estudiante = estudiante;
		this.materia = materia;
	}

	public EstudianteSOAP getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteSOAP estudiante) {
		this.estudiante = estudiante;
	}

	public MateriaSOAP getMateria() {
		return materia;
	}

	public void setMateria(MateriaSOAP materia) {
		this.materia = materia;
	}
	
	
	
	
	
	
	
}
