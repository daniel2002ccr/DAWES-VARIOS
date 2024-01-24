package com.daniel.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.daniel.colegio.dao.AlumnosDAO;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.negocio.IAlumnosServicio;

@Component
public class AlumnosServicio implements IAlumnosServicio{
	
	@Autowired
	@Qualifier("HibernateImpl")
	AlumnosDAO alumnosDAO;
	
	
	

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {
		
		return  alumnosDAO.obtenerTodosAlumnos();
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws SQLException, ClassNotFoundException, NamingException {
	
		return alumnosDAO.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		
		return alumnosDAO.insertarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
	}

	@Override
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return  alumnosDAO.actualizarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
	}

	@Override
	public Integer borrarAlumno(String id) throws SQLException, ClassNotFoundException, NamingException {
		
		return alumnosDAO.borrarAlumno(id);

	}
}
