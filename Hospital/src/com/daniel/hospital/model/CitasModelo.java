package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.CitasDTO;
import com.daniel.hospital.utils.DBUtils;

public class CitasModelo {


	public Integer crearCita (String pacienteNombre, String medicoNombre, String fecha, String hora, String estado)  throws ClassNotFoundException, SQLException{
		
		
		String sql = "INSERT INTO citas (PacienteID, MedicoID, Fecha, Hora, EstadoID) VALUES ((SELECT p.id FROM pacientes p WHERE p.nombre = ?),"
				+ " (SELECT m.id FROM medicos m WHERE m.nombre = ?),"
				+ " ?, ?, (SELECT e.id FROM estadocitas e WHERE e.estado = ?))";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1, pacienteNombre);
		ps.setString(2, medicoNombre);
		ps.setString(3, fecha);
		ps.setString(4, hora);
		ps.setString(5, estado);		
		resultado = ps.executeUpdate();
		connection.close();
		
		return resultado;
	
}
	public List<CitasDTO> buscarCita(int citaId, int pacienteId, int medicoId, String fecha, String hora, String estado) throws ClassNotFoundException, SQLException{
		
		
		String sql = "SELECT * FROM citas WHERE ID LIKE ? AND PacienteID = (SELECT p.id FROM pacientes p WHERE p.nombre = ?) AND MedicoID = (SELECT m.id FROM medicos m WHERE m.nombre = ?) AND Fecha LIKE ? "
				+ "AND Hora LIKE ? AND  EstadoID = (SELECT e.id FROM estadocitas e WHERE e.estado)";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(sql);
		
		ps.setInt(1, citaId);
		ps.setString(2, "%" + pacienteId + "%");
	    ps.setString(3, "%" + medicoId + "%");
	    ps.setString(4, "%" + fecha + "%");
	    ps.setString(5, "%" + hora + "%");
	    ps.setString(6, "%" + estado + "%");
		
	    ResultSet rs = ps.executeQuery();
	    List<CitasDTO> listaCitas = new ArrayList<>();
	    
	    while (rs.next()) {
	    	listaCitas.add(new CitasDTO(rs.getInt("ID"),
	                rs.getInt("PacienteID"),
	                rs.getInt("MedicoID"),
	                rs.getString("Fecha"),
	                rs.getString("Hora"),
	                rs.getString("Estado")
	                ));
			
		}
		return listaCitas;
		
	}
	public Integer actualizaCita (int citaId, String pacienteNombre, String medicoNombre, String fecha, String hora, String estado)  throws ClassNotFoundException, SQLException{
		
		
		String sql = "UPDATE citas SET "
	            + "pacienteID = (SELECT p.id FROM pacientes p WHERE p.nombre = ?), "
	            + "medicoID = (SELECT m.id FROM medicos m WHERE m.nombre = ?), "
	            + "Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END, "
	            + "Hora = CASE WHEN ? = '' THEN Hora ELSE ? END, "
	            + "EstadoID = (SELECT e.id FROM estadocitas e WHERE e.estado = ?) "
	            + "WHERE ID = ?";

		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1, pacienteNombre);
		ps.setString(2, medicoNombre);
		ps.setString(3, fecha);
		ps.setString(4, fecha);
		ps.setString(5, hora);
		ps.setString(6, hora);
		ps.setString(7, estado);
		ps.setInt(8, citaId);
		
		
		resultado = ps.executeUpdate();
		return resultado;
		
	}
		
}
