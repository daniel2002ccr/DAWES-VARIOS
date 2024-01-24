package com.daniel.colegio.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.colegio.dao.AlumnosDAO;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.utils.DBUtils;

@Component("JDBCImpl")
public class AlumnosDAOJdbc implements AlumnosDAO{
//	private static final Logger logger = LoggerFactory.getLogger(ControladorPruebaConexionBBDD.class);
    
	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws SQLException, ClassNotFoundException, NamingException {
		ResultSet alumnosResultSet = null;
		List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		
		Connection connection = DBUtils.conectaBBDD();
		
		Statement st = connection.createStatement();
		alumnosResultSet = st.executeQuery("SELECT * FROM alumnos");
		
		while(alumnosResultSet.next()) {
			listaAlumnos.add(new AlumnoDTO(alumnosResultSet.getInt(1), alumnosResultSet.getString(2)));
//			logger.info("Añadido el fokin alumno " + alumnosResultSet.getInt(1) + " " + alumnosResultSet.getString(2));
		}
		return listaAlumnos;
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa) throws SQLException, ClassNotFoundException, NamingException{

		
		String sql = " SELECT a.id, a.nombre, a.apellidos, m.nombre, a.id_municipio, a.familia_numerosa, a.activo"
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
			listaAlumnos.add(new AlumnoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
		}
		c.close();
		return listaAlumnos;
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		
		String sql = " INSERT INTO alumnos (id, nombre, apellidos, id_municipio, familia_numerosa, activo) VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, id);
		ps.setString(2, nombre);
		ps.setString(3, apellido);
		ps.setString(4, municipios);
		ps.setString(5, famNumerosa);
		ps.setString(6, activo);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		
		return resultado;
	}

	@Override
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipios) throws SQLException, ClassNotFoundException, NamingException {
		String sql = " UPDATE alumnos SET nombre = ?, apellidos = ?, activo = ?, familia_numerosa = ?, id_municipio = ? WHERE id = ?";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, activo);
		ps.setString(4, famNumerosa);
		ps.setString(5, municipios);
		ps.setString(6, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

	@Override
	public Integer borrarAlumno(String id) throws SQLException, ClassNotFoundException, NamingException {
		String sql = " UPDATE alumnos SET activo = 0 WHERE id = ?";
			
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

}
