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

	@Override
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return new AlumnosDAOJdbc().actualizarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
	}

	@Override
	public Integer borrarAlumno(String id) throws SQLException, ClassNotFoundException, NamingException {
		
		return new AlumnosDAOJdbc().borrarAlumno(id);

	}
}
