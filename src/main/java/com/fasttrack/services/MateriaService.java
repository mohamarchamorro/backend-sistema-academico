package com.fasttrack.services;

import java.util.List;

import com.fasttrack.dto.MateriaDTO;
import com.fasttrack.models.Materia;


public interface MateriaService {

	List<Materia> findAll();
	
	List<Materia> findAllByEstudiante(Long idEstudiante);
	
	Materia findById(Long id);
	
	void save(MateriaDTO materiaDTO);
	
	void updateById(MateriaDTO materiaDTO, Long id);
	
	void deleteById(Long id);
	
}
