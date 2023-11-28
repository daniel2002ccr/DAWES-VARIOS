package com.daniel.colegio.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.daniel.colegio.controlador.ControladorPruebaConexionBBDD;
import com.daniel.colegio.dao.AlumnosDAO;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.utils.DBUtils;

public class AlumnosDAOJdbc implements AlumnosDAO{
	private static final Logger logger = LoggerFactory.getLogger(ControladorPruebaConexionBBDD.class);
    
	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws SQLException, ClassNotFoundException, NamingException {
		ResultSet alumnosResultSet = null;
		List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		
		Connection connection = DBUtils.conectaBBDD();
		
		Statement st = connection.createStatement();
		alumnosResultSet = st.executeQuery("SELECT * FROM alumnos");
		
		while(alumnosResultSet.next()) {
			listaAlumnos.add(new AlumnoDTO(alumnosResultSet.getInt(1), alumnosResultSet.getString(2)));
			logger.info("Añadido el fokin alumno " + alumnosResultSet.getInt(1) + " " + alumnosResultSet.getString(2));
		}
		return listaAlumnos;
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa) throws SQLException, ClassNotFoundException, NamingException{

		
		String sql = " SELECT a.id, a.nombre, a.apellidos, m.nombre "
				+ " FROM alumnos a "
				+ " INNER JOIN municipios m "
				+ " ON a.id_municipio = m.id_municipio "
				+ " WHERE a.id LIKE ? AND a.nombre LIKE ? AND a.apellidos LIKE ? "
				+ " AND a.activo = ? "
				+ " AND a.familia_numerosa = ? ";
		
		Connection c = DBUtils.conectaBBDD();
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" +id+ "%");
		ps.setString(2, "%" +nombre+ "%");
		ps.setString(3, "%" +apellido+ "%");
		ps.setString(4, activo);
		ps.setString(5, famNumerosa);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaAlumnos.add(new AlumnoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		return listaAlumnos;
	}

}
