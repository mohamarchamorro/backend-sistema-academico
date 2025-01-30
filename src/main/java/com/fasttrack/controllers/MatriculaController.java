package com.fasttrack.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasttrack.services.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin(origins= {"http://localhost:4200"})
public class MatriculaController {
	
	private static final Logger logger = LoggerFactory.getLogger(MatriculaController.class);

	@Autowired
	private MatriculaService matriculaService;
	
	@GetMapping("/{nombre}")
	public ResponseEntity<?> test(@PathVariable(name="nombre") String nombre){
		logger.info("test(): /api/matriculas/{nombre}");
		return ResponseEntity.ok(matriculaService.estudiantesByMateria(nombre));
	}
	
	
	@DeleteMapping("/{idEstudiante}/{idMateria}")
	public ResponseEntity<?> unEnroll(@PathVariable(name="idEstudiante") Long idEstudiante,
			@PathVariable(name="idMateria") Long idMateria){
		logger.info("unEnroll(): idEstudiante: "+idEstudiante+", idMateria: "+idMateria);
		try {
			matriculaService.delete(idEstudiante, idMateria);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("/{idEstudiante}/{idMateria}")
	public ResponseEntity<?> enroll(@PathVariable(name="idEstudiante") Long idEstudiante,
			@PathVariable(name="idMateria") Long idMateria){
		logger.info("enroll(): idEstudiante: "+idEstudiante+", idMateria: "+idMateria);
		try {
			matriculaService.create(idEstudiante, idMateria);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
