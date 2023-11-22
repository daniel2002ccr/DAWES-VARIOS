package com.daniel.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.colegio.dao.jdbc.impl.AlumnosDAOJdbc;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.negocio.IAlumnosServicio;

public class AlumnosServicio implements IAlumnosServicio{

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {
		
		return new AlumnosDAOJdbc().obtenerTodosAlumnos();
	}

}
