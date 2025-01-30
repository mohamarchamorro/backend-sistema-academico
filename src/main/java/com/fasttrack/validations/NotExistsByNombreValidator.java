package com.fasttrack.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasttrack.repositories.MateriaRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class NotExistsByNombreValidator implements ConstraintValidator<NotExistsByNombre, String>{
	
	@Autowired
	private MateriaRepository materiaRepository;

	@Override
	@Transactional(readOnly=true)
	public boolean isValid(String nombre, ConstraintValidatorContext context) {
		
		if(materiaRepository.findByNombre(nombre)!=null) {
			return false;
		}
		
		
		return true;
	}

}
