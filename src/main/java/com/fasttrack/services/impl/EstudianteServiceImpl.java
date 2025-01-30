package com.fasttrack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasttrack.dto.EstudianteDTO;
import com.fasttrack.exceptions.NotFoundException;
import com.fasttrack.models.Estudiante;
import com.fasttrack.models.Pais;
import com.fasttrack.repositories.EstudianteRepository;
import com.fasttrack.repositories.PaisRepository;
import com.fasttrack.services.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Estudiante> findAll() {
		return estudianteRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Estudiante findById(Long id) {
		Estudiante estudiante = estudianteRepository.findById(id);
		if(estudiante==null) {
			throw new NotFoundException("No encontrado");
		}
		
		return estudiante;

	}

	@Override
	@Transactional
	public void save(EstudianteDTO estudianteDTO) {
		//Aqui debo generar el correo con el nombre, apellido, pais
		//tambien debo validar si el correo existe, si ya existe itero con un contador
		
		
		
		//estudianteRepository.save(estudianteDTO);
		
		Estudiante estudiante = new Estudiante();
		estudiante.setPrimer_nombre(estudianteDTO.getPrimer_nombre());
		estudiante.setPrimer_apellido(estudianteDTO.getPrimer_apellido());
		
		Pais pais = paisRepository.findById(estudianteDTO.getId_pais());
		if(pais==null) {
			throw new NotFoundException("Error");
		}
		
		estudiante.setId_pais(estudianteDTO.getId_pais());
		
		estudiante.setCorreo_electronico(generateEmail(estudiante.getPrimer_nombre()
				,estudiante.getPrimer_apellido()
				,pais.getCodigo_iso_2()));
		
		
		estudianteRepository.save(estudiante);
		
	}

	@Override
	@Transactional
	public void updateById(EstudianteDTO estudianteDTO, Long id) {
		//Aqui tambien, porque es posible que cambie el nombre, apellido y pais
		//Aqui debo generar el correo con el nombre, apellido, pais
		//tambien debo validar si el correo existe, si ya existe itero con un contador
		
		//estudianteRepository.updateById(estudiante, id);
		

		Estudiante estudiante = estudianteRepository.findById(id);
		if(estudiante==null) {
			throw new NotFoundException("No encontrado");
		}

		Pais pais = paisRepository.findById(estudianteDTO.getId_pais());
		if(pais==null) {
			throw new NotFoundException("Error");
		}
		
		
		if(!estudianteDTO.getId_pais().equals(estudiante.getId_pais()) || 
				!estudianteDTO.getPrimer_apellido().equals(estudiante.getPrimer_apellido())
				|| !estudianteDTO.getPrimer_nombre().equals(estudiante.getPrimer_nombre())) {
			
			estudiante.setPrimer_nombre(estudianteDTO.getPrimer_nombre());
			estudiante.setPrimer_apellido(estudianteDTO.getPrimer_apellido());
			estudiante.setId_pais(estudianteDTO.getId_pais());

			estudiante.setCorreo_electronico(generateEmail(estudiante.getPrimer_nombre()
					,estudiante.getPrimer_apellido()
					,pais.getCodigo_iso_2()));
			
			
			estudianteRepository.updateById(estudiante, id);
		}
		
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {

		if(estudianteRepository.findById(id)==null) {
			throw new NotFoundException("No encontrado");
		}
		estudianteRepository.deleteById(id);
		
	}
	
	
	public String generateEmail(String nombre, String apellido, String paisISO) {
	    
	    String baseCorreo = (nombre + "." + apellido).toLowerCase().replaceAll("\\s+", "");
	    String correo = baseCorreo + "@" + "fasttrack.com." +paisISO.toLowerCase();

	    
	    int contador = 1;

	    while (estudianteRepository.findByCorreoElectronico(correo) != null) {
	        
	        correo = baseCorreo + "." + contador + "@" + "fasttrack.com." + paisISO.toLowerCase();
	        contador++;
	    }

	    return correo;
	}

}
