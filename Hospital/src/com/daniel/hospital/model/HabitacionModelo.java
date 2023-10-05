package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.HabitacionDTO;
import com.daniel.hospital.utils.DBUtils;

public class HabitacionModelo {

	
	public Integer crearHabitacion (int habId, String tipo, String estado, float costeDia) throws ClassNotFoundException, SQLException{
		
		String sql = "INSERT INTO habitaciones (ID, Tipo, Estado, CostoPorDia) VALUES (?, ?, ?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1, habId);
		ps.setString(2, tipo);
		ps.setString(3, estado);
		ps.setFloat(4, costeDia);
		
		resultado = ps.executeUpdate();
		connection.close();
		
		return resultado;
	}
	
	
	public List<HabitacionDTO> buscarHabitacion(int habId, String tipo, String estado, float costeDia) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM habitaciones WHERE ID LIKE ? AND Tipo LIKE ? AND Estado LIKE ? AND CostoPorDia >= ?;";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,  "%" + habId + "%");
		ps.setString(2, "%" + tipo + "%");
		ps.setString(3, "%" + estado + "%");
		ps.setFloat(4, costeDia);
//		System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();
		
		List<HabitacionDTO> listaHabitaciones = new ArrayList<>();
		
		while (rs.next()) {
			listaHabitaciones.add(new HabitacionDTO(rs.getInt("ID"), rs.getString("Tipo"), rs.getString("Estado"), rs.getFloat("CostoPorDia")));
			
		}
		return listaHabitaciones;
		
	}
	public Integer actualizarHabitacion(int habId, String tipo, String estado, float costeDia) throws SQLException, ClassNotFoundException{

		String sql = "UPDATE habitaciones "
				+ "SET Tipo = CASE WHEN ? = '' THEN Tipo ELSE ? END, "
				+ "Estado = CASE WHEN ? = '' THEN Estado ELSE ? END, "
				+ "CostoPorDia = CASE WHEN ? = '' THEN CostoPorDia ELSE ? END "
				+ "WHERE ID = ?;";

		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);

		ps.setString(1, tipo);
		ps.setString(2, tipo);
		
		ps.setString(3, estado);
		ps.setString(4, estado);
		
		ps.setFloat(5, costeDia);
		ps.setFloat(6, costeDia);
		
		
		ps.setInt(7, habId);
		resultado = ps.executeUpdate();
		return resultado;
		
	}
}
