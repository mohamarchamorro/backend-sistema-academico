package com.fasttrack.models.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estudiante", propOrder = {
    "id",
    "primerNombre",
    "primerApellido",
    "idPais",
    "correoElectronico"
})
public class EstudianteSOAP {

	@XmlElement(name="id",required = true)
    private Long id;
    @XmlElement(name="primerNombre",required = true)
    private String primerNombre;
    @XmlElement(name="primerApellido",required = true)
    private String primerApellido;
    @XmlElement(name="idPais",required = true)
    private Long idPais;
    @XmlElement(name="correoElectronico",required = true)
    private String correoElectronico;
    
    
    
    
	public EstudianteSOAP(Long id, String primerNombre, String primerApellido, Long idPais, String correoElectronico) {
		this.id = id;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.idPais = idPais;
		this.correoElectronico = correoElectronico;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
    
    
    
    

	

}
