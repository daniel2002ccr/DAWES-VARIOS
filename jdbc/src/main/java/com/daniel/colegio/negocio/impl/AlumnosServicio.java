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

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws SQLException, ClassNotFoundException, NamingException {
	
		return new AlumnosDAOJdbc().buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		
		return new AlumnosDAOJdbc().insertarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
	}

}
