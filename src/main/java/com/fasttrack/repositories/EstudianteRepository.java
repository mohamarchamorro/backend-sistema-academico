package com.fasttrack.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasttrack.mappers.EstudianteRowMapper;
import com.fasttrack.models.Estudiante;

@Repository
public class EstudianteRepository {
	

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public List<Estudiante> findAll(){
    	String sql = "SELECT * FROM estudiantes";
    	
    	return jdbcTemplate.query(sql, new EstudianteRowMapper());
    	
    }
    
    public Estudiante findById(Long id) {
    	String sql = "SELECT * FROM estudiantes WHERE id=?";
    	

        List<Estudiante> estudiantes = jdbcTemplate.query(sql, new EstudianteRowMapper(), id);
        
        if (estudiantes.isEmpty()) {
            return null;
        }
        
        return estudiantes.get(0);
    	
    }
    

    public Estudiante findByCorreoElectronico(String correo_electronico) {
        String sql = "SELECT * FROM estudiantes WHERE correo_electronico=?";
        
        List<Estudiante> estudiantes = jdbcTemplate.query(sql, new EstudianteRowMapper(), correo_electronico);
        
        if (estudiantes.isEmpty()) {
            return null;
        }
        
        return estudiantes.get(0);
    	
    }
    
    public void save(Estudiante estudiante) {

    	String sql = "INSERT INTO estudiantes (primer_nombre,primer_apellido,id_pais,correo_electronico) values (?,?,?,?)";
    	
    	jdbcTemplate.update(sql, estudiante.getPrimer_nombre(),estudiante.getPrimer_apellido(),estudiante.getId_pais()
    			,estudiante.getCorreo_electronico());
    }
    
    
    public void updateById(Estudiante estudiante, Long id) {
    	String sql = "UPDATE estudiantes SET primer_nombre=?, primer_apellido=?, id_pais=?, correo_electronico=?"
    			+ "WHERE id=?";
    	
    	jdbcTemplate.update(sql, estudiante.getPrimer_nombre(),estudiante.getPrimer_apellido(),estudiante.getId_pais()
    			,estudiante.getCorreo_electronico(), id);
    	
    }
    	
    
    public void deleteById(Long id) {
    	String sql = "DELETE FROM estudiantes WHERE id=?";
    	
    	jdbcTemplate.update(sql,id);
    }
    	
    	
    

}
