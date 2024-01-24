package com.daniel.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.colegio.dtos.AlumnoDTO;

public interface IAlumnosServicio {

	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException;
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa) throws SQLException, ClassNotFoundException, NamingException;
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa, String municipios)throws SQLException, ClassNotFoundException, NamingException;
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa, String municipios)throws SQLException, ClassNotFoundException, NamingException;
	public Integer borrarAlumno(String id)throws SQLException, ClassNotFoundException, NamingException;

}


