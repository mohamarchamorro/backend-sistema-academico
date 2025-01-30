package com.fasttrack.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasttrack.models.Pais;
import com.fasttrack.repositories.PaisRepository;
import com.fasttrack.services.PaisService;

@Service
public class PaisServiceImpl implements PaisService {
	
	@Autowired
	private PaisRepository paisRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Pais findById(Long id) {
		return paisRepository.findById(id);
	}

}
