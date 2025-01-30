package com.fasttrack.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasttrack.mappers.PaisRowMapper;
import com.fasttrack.models.Pais;

@Repository
public class PaisRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public List<Pais> findAll(){
    	String sql = "SELECT * FROM paises";
    	
    	return jdbcTemplate.query(sql, new PaisRowMapper());
    	
    }
    
    public Pais findById(Long id) {
    	String sql = "SELECT * FROM paises WHERE id=?";
    	
    	List<Pais> paises = jdbcTemplate.query(sql, new PaisRowMapper(),id);
    	

        if (paises.isEmpty()) {
            return null;
        }
        
        return paises.get(0);
    	
    }
    
}
