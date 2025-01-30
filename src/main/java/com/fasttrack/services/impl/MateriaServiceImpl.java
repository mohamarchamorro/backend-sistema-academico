package com.fasttrack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasttrack.dto.MateriaDTO;
import com.fasttrack.exceptions.NotFoundException;
import com.fasttrack.models.Estudiante;
import com.fasttrack.models.Materia;
import com.fasttrack.repositories.EstudianteRepository;
import com.fasttrack.repositories.MateriaRepository;
import com.fasttrack.services.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService {
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Materia> findAll() {
		return materiaRepository.findAll();
	}
	


	@Override
	@Transactional(readOnly=true)
	public List<Materia> findAllByEstudiante(Long idEstudiante) {

		Estudiante estudiante = estudianteRepository.findById(idEstudiante);
		
		if(estudiante==null) {
			throw new NotFoundException("No encontrado");
		}
		
		
		return materiaRepository.findAllByEstudiante(idEstudiante);
	}


	@Override
	@Transactional(readOnly=true)
	public Materia findById(Long id) {
		Materia materia = materiaRepository.findById(id);
		
		if(materia==null) {
			throw new NotFoundException("No encontrado");
		}
		
		return materia;
	}

	@Override
	@Transactional
	public void save(MateriaDTO materiaDTO) {
		materiaRepository.save(new Materia(materiaDTO.getNombre()));

	}

	@Override
	@Transactional
	public void updateById(MateriaDTO materiaDTO, Long id) {

		Materia materia = materiaRepository.findById(id);
		
		if(materia==null) {
			throw new NotFoundException("No encontrado");
		}
		
		materia.setNombre(materiaDTO.getNombre());
			
		materiaRepository.updateById(materia, id);
		
		


	}

	@Override
	@Transactional
	public void deleteById(Long id) {

		Materia materia = materiaRepository.findById(id);
		
		if(materia==null) {
			throw new NotFoundException("No encontrado");
		}
		
		materiaRepository.deleteById(id);

	}
}
