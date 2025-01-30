package com.fasttrack.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasttrack.mappers.MateriaRowMapper;
import com.fasttrack.models.Materia;

@Repository
public class MateriaRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public List<Materia> findAll(){
    	String sql = "SELECT * FROM materias order by id asc";
    	
    	return jdbcTemplate.query(sql, new MateriaRowMapper());
    	
    }
    

    public List<Materia> findAllByEstudiante(Long idEstudiante){
    	String sql = "SELECT m.id, m.nombre FROM materias m, matriculas mt "
    			+ "WHERE m.id = mt.id_materia "
    			+ "AND mt.id_estudiante=? "
    			+ "ORDER BY m.id asc";
    	
    	return jdbcTemplate.query(sql, new MateriaRowMapper(), idEstudiante);
    	
    }
    
    
    public Materia findById(Long id) {
    	String sql = "SELECT * FROM materias WHERE id=?";
    	
    	List<Materia> materias =  jdbcTemplate.query(sql, new MateriaRowMapper(),id);
    	

        if (materias.isEmpty()) {
            return null;
        }
        
        return materias.get(0);
    	
    }
    

    public Materia findByNombre(String nombre) {
    	String sql = "SELECT * FROM materias WHERE nombre=?";
    	

    	List<Materia> materias =  jdbcTemplate.query(sql, new MateriaRowMapper(),nombre);
    	

        if (materias.isEmpty()) {
            return null;
        }
        
        return materias.get(0);
    	
    }
    
    public void save(Materia materia) {

    	String sql = "INSERT INTO materias (nombre) values (?)";
    	
    	jdbcTemplate.update(sql, materia.getNombre());
    }
    
    
    public void updateById(Materia materia, Long id) {
    	String sql = "UPDATE materias SET nombre=? WHERE id=?";
    	
    	jdbcTemplate.update(sql, materia.getNombre(), id);
    	
    }
    	
    
    public void deleteById(Long id) {
    	String sql = "DELETE FROM materias WHERE id=?";
    	
    	jdbcTemplate.update(sql,id);
    }
    	
    	
}
