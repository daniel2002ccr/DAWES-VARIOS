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
	public List<CitasDTO> buscarCita(int citaId, String pacienteNombre, String medicoNombre, String fecha, String hora, String estado) throws ClassNotFoundException, SQLException {
	    String sql = "SELECT c.ID as CitaID, p.Nombre as PacienteNombre, m.Nombre as MedicoNombre, c.Fecha, c.Hora, e.Estado " +
	                 "FROM citas c " +
	                 "INNER JOIN pacientes p ON c.PacienteID = p.ID " +
	                 "INNER JOIN medicos m ON c.MedicoID = m.ID " +
	                 "INNER JOIN estadocitas e ON c.EstadoID = e.ID " +
	                 "WHERE c.ID LIKE ? AND p.Nombre LIKE ? AND m.Nombre LIKE ? AND c.Fecha LIKE ? AND c.Hora LIKE ? AND e.Estado LIKE ?";

	    Connection conexionBBDD = DBUtils.conexionBBDD();
	    PreparedStatement ps = conexionBBDD.prepareStatement(sql);

	    // Set parameters
	    ps.setString(1, "%" + citaId + "%");
	    ps.setString(2, "%" + pacienteNombre + "%");
	    ps.setString(3, "%" + medicoNombre + "%");
	    ps.setString(4, "%" + fecha + "%");
	    ps.setString(5, "%" + hora + "%");
	    ps.setString(6, "%" + estado + "%");

	    ResultSet rs = ps.executeQuery();
	    List<CitasDTO> listaCitas = new ArrayList<>();

	    while (rs.next()) {
	        listaCitas.add(new CitasDTO(rs.getInt("CitaID"),
	                rs.getString("PacienteNombre"),
	                rs.getString("MedicoNombre"),
	                rs.getString("Fecha"),
	                rs.getString("Hora"),
	                rs.getString("Estado")));
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
