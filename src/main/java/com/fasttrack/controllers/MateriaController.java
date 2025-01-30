package com.fasttrack.controllers;

import java.util.HashMap;
import java.util.Map;

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

import com.fasttrack.dto.MateriaDTO;
import com.fasttrack.exceptions.NotFoundException;
import com.fasttrack.services.MateriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/materias")
@CrossOrigin(origins= {"http://localhost:4200"})
public class MateriaController {
	
	@Autowired
	private MateriaService materiaService;
	

	@GetMapping
	public ResponseEntity<?> getAll(){
		try {
			
			return ResponseEntity.ok(materiaService.findAll());
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable(name="id") Long id){
		try {
			
			return ResponseEntity.ok(materiaService.findById(id));
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	

	@GetMapping("/search/{idEstudiante}")
	public ResponseEntity<?> getByEstudiante(@PathVariable(name="idEstudiante") Long idEstudiante){
		
		try {
			
			return ResponseEntity.ok(materiaService.findAllByEstudiante(idEstudiante));
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		try {
			materiaService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody MateriaDTO materiaDTO, BindingResult result){
		
		try {
			if(result.hasErrors()) {
				return validateMateria(result);
			}
			
			materiaService.save(materiaDTO);
			return ResponseEntity.ok().build();
		}catch(DataAccessException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name="id") Long id, @Valid @RequestBody MateriaDTO materiaDTO, BindingResult result){

		try {
			if(result.hasErrors()) {
				return validateMateria(result);
			}
			
			materiaService.updateById(materiaDTO,id);
			return ResponseEntity.ok().build();
		}catch(DataAccessException e) {
			return ResponseEntity.badRequest().build();
		}catch(NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	private ResponseEntity<?> validateMateria(BindingResult result){
		Map<String, String> errors = new HashMap<>();
		
		result.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
		
		return ResponseEntity.badRequest().body(errors);
	}
}
