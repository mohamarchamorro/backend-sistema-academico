package com.fasttrack.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasttrack.models.Matricula;
import com.fasttrack.repositories.MatriculaRepository;
import com.fasttrack.services.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	@Transactional
	public void delete(Long idEstudiante, Long idMateria) {
		matriculaRepository.delete(idEstudiante, idMateria);

	}

	@Override
	@Transactional
	public void create(Long idEstudiante, Long idMateria) {
		matriculaRepository.create(idEstudiante, idMateria);

	}

	@Override
	@Transactional(readOnly=true)
	public List<Matricula> materiasByEstudiante(Long idEstudiante) {
		return matriculaRepository.materiasByEstudiante(idEstudiante);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Matricula> estudiantesByMateria(String nombre) {
		
		return matriculaRepository.estudiantesByMateria(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

}
