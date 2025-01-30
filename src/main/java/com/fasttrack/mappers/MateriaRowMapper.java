package com.fasttrack.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasttrack.models.Materia;

public class MateriaRowMapper implements RowMapper<Materia>{

	@Override
	public Materia mapRow(ResultSet rs, int rowNum) throws SQLException {
		Materia materia = new Materia(rs.getLong("id"),rs.getString("nombre"));
		
		return materia;
	}

}
