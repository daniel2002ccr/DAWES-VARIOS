package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.DepartamentosDTO;
import com.daniel.hospital.dtos.EstadoCitasDTO;
import com.daniel.hospital.utils.DBUtils;

public class EstadoCitasModelo {

	public Integer crearEstadoCita(int id, String estado) throws SQLException, ClassNotFoundException {		
		String sql = "INSERT INTO estadocitas (ID, Estado) VALUES (?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1, id);
		ps.setString(2, estado);
		
		
		resultado = ps.executeUpdate();
		connection.close();
		
		
		return resultado;
		
	}
public List <EstadoCitasDTO> buscarEstadoCita (int id, String estado) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM estadocitas WHERE ID LIKE ? AND Estado LIKE ?;";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,  "%" + id + "%");
		ps.setString(2, "%" + estado + "%");
		
		
		ResultSet rs = ps.executeQuery();
		
		
		List<EstadoCitasDTO> listaEstadoCitasDTO = new ArrayList<>();
		
		while (rs.next()) {
			listaEstadoCitasDTO.add(new EstadoCitasDTO(rs.getInt("ID"), rs.getString("Estado")));
			
		}
		
		return listaEstadoCitasDTO;
		
	}
public Integer actualizarEstadoCitas(int id, String estado) throws SQLException, ClassNotFoundException{

	String sql = "UPDATE estadocitas "
			+ "SET Estado = CASE WHEN ? = '' THEN Estado ELSE ? END "
			+ "WHERE ID = ?;";

	
	Connection connection = DBUtils.conexionBBDD();
	PreparedStatement ps = null;
	Integer resultado = null;
	
	
	ps = connection.prepareStatement(sql);

	ps.setString(1, estado);
	ps.setString(2, estado);
	
	ps.setInt(3, id);
	resultado = ps.executeUpdate();
	
	
	return resultado;
	
}
}
