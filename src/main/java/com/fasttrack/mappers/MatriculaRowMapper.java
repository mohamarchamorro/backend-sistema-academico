package com.fasttrack.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasttrack.models.Estudiante;
import com.fasttrack.models.Materia;
import com.fasttrack.models.Matricula;

public class MatriculaRowMapper implements RowMapper<Matricula>{

	@Override
	public Matricula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Matricula matricula = new Matricula(
				
				new Estudiante(rs.getLong("e.id"), 
				rs.getString("e.primer_nombre"),
				rs.getString("e.primer_apellido"),
				rs.getLong("e.id_pais"),
				rs.getString("e.correo_electronico")),
						
				
				
				new Materia(rs.getLong("m.id"), rs.getString("m.nombre")));
		
		return matricula;
	}

}
