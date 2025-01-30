package com.fasttrack.services;

import java.util.List;

import com.fasttrack.models.Matricula;

public interface MatriculaService {

	void delete(Long idEstudiante, Long idMateria);
	
	void create(Long idEstudiante, Long idMateria);
	
	List<Matricula> materiasByEstudiante(Long idEstudiante);
	
	List<Matricula> estudiantesByMateria(String nombre);
	
	List<Matricula> findAll();
}
