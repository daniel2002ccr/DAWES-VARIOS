package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.daniel.hospital.dtos.HistorialMedicoDTO;
import com.daniel.hospital.utils.DBUtils;

public class HistorialMedicoModelo {

	public Integer crearHistorial (String pacienteNombre, String medicoNombre, String fecha, String diagnostico, String tratamiento)  throws ClassNotFoundException, SQLException{
		
		
		String sql = "INSERT INTO historialmedico (PacienteID, MedicoID, Fecha, Diagnostico, Tratamiento) VALUES ((SELECT p.id FROM pacientes p WHERE p.nombre = ?),"
				+ " (SELECT m.id FROM medicos m WHERE m.nombre = ?),"
				+ " ?, ?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1, pacienteNombre);
		ps.setString(2, medicoNombre);
		ps.setString(3, fecha);
		ps.setString(4, diagnostico);
		ps.setString(5, tratamiento);
		
		resultado = ps.executeUpdate();
		connection.close();
		
		return resultado;

	}
	public List<HistorialMedicoDTO> buscarHistorial(int id, String pacienteNombre, String medicoNombre, String fecha, String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {

	    String sql = "SELECT hm.ID, p.Nombre as PacienteNombre, m.Nombre as MedicoNombre, hm.Fecha, hm.Diagnostico, hm.Tratamiento " +
	                 "FROM historialmedico hm " +
	                 "INNER JOIN pacientes p ON hm.PacienteID = p.ID " +
	                 "INNER JOIN medicos m ON hm.MedicoID = m.ID " +
	                 "WHERE hm.ID LIKE ? AND p.Nombre LIKE ? AND m.Nombre LIKE ? AND hm.Fecha LIKE ? AND hm.Diagnostico LIKE ? AND hm.Tratamiento LIKE ?";

	    Connection conexionBBDD = DBUtils.conexionBBDD();
	    PreparedStatement ps = conexionBBDD.prepareStatement(sql);

	    ps.setInt(1, id);
	    ps.setString(2, "%" + pacienteNombre + "%");
	    ps.setString(3, "%" + medicoNombre + "%");
	    ps.setString(4, "%" + fecha + "%");
	    ps.setString(5, "%" + diagnostico + "%");
	    ps.setString(6, "%" + tratamiento + "%");

	    ResultSet rs = ps.executeQuery();
	    List<HistorialMedicoDTO> listaHistorial = new ArrayList<>();

	    while (rs.next()) {
	        listaHistorial.add(new HistorialMedicoDTO(rs.getInt("ID"),
	                rs.getString("PacienteNombre"),
	                rs.getString("MedicoNombre"),
	                rs.getString("Fecha"),
	                rs.getString("Diagnostico"),
	                rs.getString("Tratamiento")));
	    }
	    return listaHistorial;
	}
	public Integer actualizarHistorial (int id, String pacienteNombre, String medicoNombre, String fecha, String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException{
		
		String sql = "UPDATE historialmedico SET "
	            + "pacienteID = (SELECT p.id FROM pacientes p WHERE p.nombre = ?), "
	            + "medicoID = (SELECT m.id FROM medicos m WHERE m.nombre = ?), "
	            + "Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END, "
	            + "Diagnostico = CASE WHEN ? = '' THEN Diagnostico ELSE ? END, "
	            + "Tratamiento = CASE WHEN ? = '' THEN Tratamiento ELSE ? END "
	            + "WHERE ID = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
ps = connection.prepareStatement(sql);
		
		ps.setString(1, pacienteNombre);
		ps.setString(2, medicoNombre);
		ps.setString(3, fecha);
		ps.setString(4, fecha);
		ps.setString(5, diagnostico);
		ps.setString(6, diagnostico);
		ps.setString(7, tratamiento);
		ps.setString(8, tratamiento);
		ps.setInt(9, id);
		
		
		resultado = ps.executeUpdate();
		return resultado;
	}
}