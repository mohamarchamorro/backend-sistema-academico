package com.fasttrack.services;

import java.util.List;

import com.fasttrack.dto.EstudianteDTO;
import com.fasttrack.models.Estudiante;

public interface EstudianteService {

	
	List<Estudiante> findAll();
	
	Estudiante findById(Long id);
	
	void save(EstudianteDTO estudianteDTO);
	
	void updateById(EstudianteDTO estudianteDTO, Long id);
	
	void deleteById(Long id);
	
	
}
