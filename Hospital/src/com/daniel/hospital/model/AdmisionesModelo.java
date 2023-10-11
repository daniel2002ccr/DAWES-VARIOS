package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.AdmisionesDTO;
import com.daniel.hospital.dtos.CitasDTO;
import com.daniel.hospital.utils.DBUtils;

public class AdmisionesModelo {

public Integer crearAdmision (String nombrePaciente, String tipoHabitacion, String fechaEntrada, String fechaSalida,
		String motivo)  throws ClassNotFoundException, SQLException{
		
		
		String sql = "INSERT INTO admisiones (PacienteID, HabitacionID, FechaDeIngreso, FechaDeSalida, Motivo) VALUES "
				+ "((SELECT p.id FROM pacientes p WHERE p.nombre = ?),"
				+ " (SELECT h.id FROM habitaciones h WHERE h.tipo = ?),"
				+ " ?, ?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombrePaciente);
		ps.setString(2, tipoHabitacion);
		ps.setString(3, fechaEntrada);
		ps.setString(4, fechaSalida);
		ps.setString(5, motivo);		
		resultado = ps.executeUpdate();
		connection.close();
		
		return resultado;
	
}

public Integer actualizaAdmision(int id, String nombrePaciente, String tipoHabitacion, String fechaEntrada, String fechaSalida,
		String motivo) throws ClassNotFoundException, SQLException {
	
	String sql = "UPDATE admisiones SET " +
            "pacienteID = IF(? = '', pacienteID, (SELECT p.id FROM pacientes p WHERE p.nombre = ?)), " +
            "habitacionID = IF(? = '', habitacionID, (SELECT h.id FROM habitaciones h WHERE h.tipo = ?)), " +
            "FechaDeIngreso = CASE WHEN ? = '' THEN FechaDeIngreso ELSE ? END, " +
            "FechaDeSalida = CASE WHEN ? = '' THEN FechaDeSalida ELSE ? END, " +
            "Motivo = CASE WHEN ? = '' THEN Motivo ELSE ? END " +
            "WHERE ID = ?;";
	
	Connection connection = DBUtils.conexionBBDD();
	PreparedStatement ps = null;
	Integer resultado = null;
	
	ps = connection.prepareStatement(sql);
	
	ps.setString(1, nombrePaciente);
	ps.setString(2, nombrePaciente);
	ps.setString(3, tipoHabitacion);
	ps.setString(4, tipoHabitacion);
	ps.setString(5, fechaEntrada);
	ps.setString(6, fechaEntrada);
	ps.setString(7, fechaSalida);
	ps.setString(8, fechaSalida);
	ps.setString(9, motivo);
	ps.setString(10, motivo);
	ps.setInt(11, id);
	
	resultado = ps.executeUpdate();
	return resultado;
}
public List<AdmisionesDTO> buscarAdmision(int id, String pacienteNombre, String tipoHabitacion, String fechaEntrada, String fechaSalida, String motivo) throws ClassNotFoundException, SQLException {
	String sql = "SELECT a.ID, p.Nombre AS PacienteNombre, h.Tipo AS HabitacionTipo, a.FechaDeIngreso, a.FechaDeSalida, a.Motivo " +
            "FROM admisiones a " +
            "INNER JOIN pacientes p ON a.PacienteID = p.ID " +
            "INNER JOIN habitaciones h ON a.HabitacionID = h.ID " +
            "WHERE a.ID LIKE ? AND p.Nombre LIKE ? AND h.Tipo LIKE ? AND a.FechaDeIngreso LIKE ? AND FechaDeSalida LIKE ? AND Motivo LIKE ? ";

	Connection conexionBBDD = DBUtils.conexionBBDD();
    PreparedStatement ps = conexionBBDD.prepareStatement(sql);

    
    ps.setString(1, "%" + id + "%");
    ps.setString(2, "%" + pacienteNombre + "%");
    ps.setString(3, "%" + tipoHabitacion + "%");
    ps.setString(4, "%" + fechaEntrada + "%");
    ps.setString(5, "%" + fechaSalida + "%");
    ps.setString(6, "%" + motivo + "%");
    
    ResultSet rs = ps.executeQuery();
    List<AdmisionesDTO> listaAdmisiones = new ArrayList<>();
    
    while (rs.next()) {
    	listaAdmisiones.add(new AdmisionesDTO(rs.getInt("ID"),
                rs.getString("PacienteNombre"),
                rs.getString("HabitacionTipo"),
                rs.getString("FechaDeIngreso"),
                rs.getString("FechaDeSalida"),
                rs.getString("Motivo")));
    }
    return listaAdmisiones;
}
}
