package com.fasttrack.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasttrack.dto.EstudianteDTO;
import com.fasttrack.exceptions.NotFoundException;
import com.fasttrack.services.EstudianteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins= {"http://localhost:4200"})
public class EstudianteController {

	private static final Logger logger = LoggerFactory.getLogger(EstudianteController.class);
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		logger.info("getAll(): beforeTry()");
		try {
			return ResponseEntity.ok(estudianteService.findAll());
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable(name="id") Long id){
		try {
			return ResponseEntity.ok(estudianteService.findById(id));
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody EstudianteDTO estudianteDTO, BindingResult result){
		logger.info("create(): beforeTry()");
		try {
			if(result.hasErrors()) {
				return validateEstudiante(result);
			}
			
			estudianteService.save(estudianteDTO);
			logger.error("create(): afterSaveInTry()");
			return ResponseEntity.ok().build();
		}catch(DataAccessException e) {
			return ResponseEntity.badRequest().build();
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name="id") Long id, @Valid @RequestBody EstudianteDTO estudianteDTO, BindingResult result){

		try {
			if(result.hasErrors()) {
				return validateEstudiante(result);
			}
			
			estudianteService.updateById(estudianteDTO,id);
			return ResponseEntity.ok().build();
		}catch(DataAccessException e) {
			return ResponseEntity.badRequest().build();
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		try {
			estudianteService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	private ResponseEntity<?> validateEstudiante(BindingResult result){
		Map<String, String> errors = new HashMap<>();
		
		result.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		
		return ResponseEntity.badRequest().body(errors);
	}
}
