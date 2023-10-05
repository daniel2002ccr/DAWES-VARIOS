package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.HabitacionDTO;
import com.daniel.hospital.dtos.PacientesDTO;
import com.daniel.hospital.utils.DBUtils;

public class PacientesModelo {
	public Integer creaPaciente(int idPaciente, String nombre, String apellido, String fechaNac, String dni,
			String direccion, String telefono, String correoElectronico, String alergia, String historial)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO pacientes "
				+ " ( Nombre, Apellido, FechaDeNacimiento, DNI, Direccion, Telefono, CorreoElectronico, AlergiaID, HistoriaMedica) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, (SELECT a.id FROM alergias a WHERE a.descripcion = ?), ?)";

	    Connection connection = DBUtils.conexionBBDD();
	    PreparedStatement ps = null;
	    Integer resultado = null;

	    ps = connection.prepareStatement(sql);

	    
	    ps.setString(1, nombre);
	    ps.setString(2, apellido);
	    ps.setString(3, fechaNac);
	    ps.setString(4, dni);
	    ps.setString(5, direccion);
	    ps.setString(6, telefono);
	    ps.setString(7, correoElectronico);
	    ps.setString(8, alergia); 
	    ps.setString(9, historial); 

		resultado = ps.executeUpdate();
		connection.close();

		return resultado;
	}

	public List<PacientesDTO> buscarPaciente(int idPaciente, String nombre, String apellido, String fechaNac, String dni,
			String direccion, String telefono, String correoElectronico, String alergia, String historial) throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM pacientes WHERE ID LIKE ? AND Nombre LIKE ? AND Apellido LIKE ? AND FechaDeNacimiento LIKE ? AND DNI LIKE ? AND Direccion LIKE ? AND Telefono LIKE ? AND CorreoElectronico LIKE ? "
				+ "AND AlergiaID = (SELECT a.id FROM alergias a WHERE a.descripcion LIKE ?) AND HistoriaMedica LIKE ?";

		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		 ps.setString(1, "%" + idPaciente + "%");
		    ps.setString(2, "%" + nombre + "%");
		    ps.setString(3, "%" + apellido + "%");
		    ps.setString(4, "%" + fechaNac + "%");
		    ps.setString(5, "%" + dni + "%");
		    ps.setString(6, "%" + direccion + "%");
		    ps.setString(7, "%" + telefono + "%");
		    ps.setString(8, "%" + correoElectronico + "%");
		    ps.setString(9, "%" + alergia + "%");
		    ps.setString(10, "%" + historial + "%");
//		System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();
		
		List<PacientesDTO> listaPacientes = new ArrayList<>();
		
		while (rs.next()) {
			listaPacientes.add(new PacientesDTO(rs.getInt("ID"),
	                rs.getString("Nombre"),
	                rs.getString("Apellido"),
	                rs.getString("FechaDeNacimiento"),
	                rs.getString("DNI"),
	                rs.getString("Direccion"),
	                rs.getString("Telefono"),
	                rs.getString("CorreoElectronico"),
	                rs.getInt("AlergiaID"),
	                rs.getString("HistoriaMedica")));
			
		}
		return listaPacientes;
		
	}
	public Integer actualizaPaciente(int idPaciente, String nombre, String apellido, String fechaNac, String dni,
	        String direccion, String telefono, String correoElectronico, String alergia, String historial)
	        throws SQLException, ClassNotFoundException {

		String sql = "UPDATE pacientes SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END, " +
		        "Apellido = CASE WHEN ? = '' THEN Apellido ELSE ? END, " +
		        "FechaDeNacimiento = CASE WHEN ? = '' THEN FechaDeNacimiento ELSE ? END, " +
		        "DNI = CASE WHEN ? = '' THEN DNI ELSE ? END, " +
		        "Direccion = CASE WHEN ? = '' THEN Direccion ELSE ? END, " +
		        "Telefono = CASE WHEN ? = '' THEN Telefono ELSE ? END, " +
		        "CorreoElectronico = CASE WHEN ? = '' THEN CorreoElectronico ELSE ? END, " +
		        "HistoriaMedica = CASE WHEN ? = '' THEN HistoriaMedica ELSE ? END, " +
		        "AlergiaID = (SELECT a.id FROM alergias a WHERE a.descripcion = ?) " +
		        "WHERE ID = ?";
		
	    Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, nombre);
		ps.setString(3, apellido);
		ps.setString(4, apellido);
		ps.setString(5, fechaNac);
		ps.setString(6, fechaNac);
		ps.setString(7, dni);
		ps.setString(8, dni);
		ps.setString(9, direccion);
		ps.setString(10, direccion);
		ps.setString(11, telefono);
		ps.setString(12, telefono);
		ps.setString(13, correoElectronico);
		ps.setString(14, correoElectronico);
		ps.setString(15, historial);
		ps.setString(16, historial);
		ps.setString(17, alergia);
		ps.setInt(18, idPaciente);
		
		
		resultado = ps.executeUpdate();
		return resultado;

	}
}