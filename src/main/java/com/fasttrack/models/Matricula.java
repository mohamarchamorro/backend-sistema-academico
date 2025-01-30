package com.fasttrack.models;

public class Matricula {
	private Estudiante estudiante;
	
	private Materia materia;
	
	
	public Matricula() {
		
	}


	public Matricula(Estudiante estudiante, Materia materia) {
		this.estudiante = estudiante;
		this.materia = materia;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
	

	
}
