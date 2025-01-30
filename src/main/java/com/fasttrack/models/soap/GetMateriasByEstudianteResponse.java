package com.fasttrack.models.soap;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getMateriasByEstudianteResponse")
public class GetMateriasByEstudianteResponse {
	
	

    @XmlElement(name = "matriculas")
    private List<MatriculaSOAP> matriculas;

	public List<MatriculaSOAP> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<MatriculaSOAP> matriculas) {
		this.matriculas = matriculas;
	}
    
    
    
    

}
