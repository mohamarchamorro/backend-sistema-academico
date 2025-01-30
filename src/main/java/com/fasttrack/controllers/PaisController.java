package com.fasttrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasttrack.services.PaisService;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins= {"http://localhost:4200"})
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		try {
			
			return ResponseEntity.ok(paisService.findAll());
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(name="id") Long id){
		try {
			
			return ResponseEntity.ok(paisService.findById(id));
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	

}
