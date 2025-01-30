package com.fasttrack.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasttrack.models.Estudiante;

public class EstudianteRowMapper implements RowMapper<Estudiante>{

	@Override
	public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {
		Estudiante estudiante = new Estudiante(rs.getLong("id"), rs.getString("primer_nombre"),
				rs.getString("primer_apellido"), rs.getLong("id_pais"), rs.getString("correo_electronico"));
		
		
		
		return estudiante;
	}

}
