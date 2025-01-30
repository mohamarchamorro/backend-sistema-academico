package com.fasttrack.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasttrack.mappers.MatriculaRowMapper;
import com.fasttrack.models.Matricula;

@Repository
public class MatriculaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public void delete(Long idEstudiante, Long idMateria) {
    	String sql = "DELETE FROM matriculas WHERE id_estudiante=? AND id_materia=?";
    	
    	jdbcTemplate.update(sql,idEstudiante,idMateria);
    }
    	

    public void create(Long idEstudiante, Long idMateria) {
    	String sql = "INSERT INTO matriculas (id_estudiante,id_materia) values (?,?)";
    	
    	jdbcTemplate.update(sql,idEstudiante,idMateria);
    }
    
    
    public List<Matricula> materiasByEstudiante(Long idEstudiante) {
    	String sql = "SELECT e.id, e.primer_nombre, e.primer_apellido, e.id_pais, e.correo_electronico, m.id, m.nombre "
    			+ "FROM estudiantes e, materias m, matriculas mt "
    			+ "WHERE e.id = mt.id_estudiante "
    			+ "AND m.id = mt.id_materia "
    			+ "AND e.id = ?";
    	
    	List<Matricula> matriculas = jdbcTemplate.query(sql, new MatriculaRowMapper(), idEstudiante);
    	
    	return matriculas;
    	
    }
    

    public List<Matricula> estudiantesByMateria(String nombre) {
    	String sql = "SELECT e.id, e.primer_nombre, e.primer_apellido, e.id_pais, e.correo_electronico, m.id, m.nombre "
    			+ "FROM estudiantes e, materias m, matriculas mt "
    			+ "WHERE e.id = mt.id_estudiante "
    			+ "AND m.id = mt.id_materia "
    			+ "AND m.nombre = ?";
    	
    	List<Matricula> matriculas = jdbcTemplate.query(sql, new MatriculaRowMapper(), nombre);
    	
    	return matriculas;
    	
    }
    

    public List<Matricula> findAll() {
    	String sql = "SELECT e.id, e.primer_nombre, e.primer_apellido, e.id_pais, e.correo_electronico, m.id, m.nombre "
    			+ "FROM estudiantes e, materias m, matriculas mt "
    			+ "WHERE e.id = mt.id_estudiante "
    			+ "AND m.id = mt.id_materia ";
    	
    	List<Matricula> matriculas = jdbcTemplate.query(sql, new MatriculaRowMapper());
    	
    	return matriculas;
    	
    }
    	
    	
    	
    	

}
