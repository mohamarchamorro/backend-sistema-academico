package com.fasttrack.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasttrack.models.Pais;

public class PaisRowMapper implements RowMapper<Pais>{

	@Override
	public Pais mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pais pais = new Pais(rs.getLong("id"),rs.getString("nombre"),rs.getString("codigo_iso_2"));
		
		return pais;
	}

}
