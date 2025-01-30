package com.fasttrack.services;

import java.util.List;

import com.fasttrack.models.Pais;

public interface PaisService {

	List<Pais> findAll();
	
	Pais findById(Long id);
	
}
