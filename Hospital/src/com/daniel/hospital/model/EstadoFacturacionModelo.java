package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.daniel.hospital.dtos.EstadoFacturacionDTO;
import com.daniel.hospital.utils.DBUtils;

public class EstadoFacturacionModelo {

	public Integer crearEstadoFactura(int id, String estado) throws SQLException, ClassNotFoundException {		
		String sql = "INSERT INTO estadofacturacion (ID, Estado) VALUES (?, ?)";
		
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
public List <EstadoFacturacionDTO> buscarEstadoFacturacion (int id, String estado) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM estadofacturacion WHERE ID LIKE ? AND Estado LIKE ?;";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,  "%" + id + "%");
		ps.setString(2, "%" + estado + "%");
		
		
		ResultSet rs = ps.executeQuery();
		
		
		List<EstadoFacturacionDTO> listaEstadoFacturacionDTO = new ArrayList<>();
		
		while (rs.next()) {
			listaEstadoFacturacionDTO.add(new EstadoFacturacionDTO(rs.getInt("ID"), rs.getString("Estado")));
			
		}
		
		return listaEstadoFacturacionDTO;
		
	}
public Integer actualizarEstadoFacturacion(int id, String estado) throws SQLException, ClassNotFoundException{

	String sql = "UPDATE estadofacturacion "
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
