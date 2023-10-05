package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.FarmaciaDTO;
import com.daniel.hospital.utils.DBUtils;

public class FarmaciaModelo {

	public Integer crearFarmacia(int idFarmacia, String nombreFarmacia, String descripcionFarmacia,
			int cantidadDisponible, float precio) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO farmacia (ID, Nombre, Descripcion, CantidadDisponible, Precio) VALUES (?, ?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, idFarmacia);
		ps.setString(2, nombreFarmacia);
		ps.setString(3, descripcionFarmacia);
		ps.setInt(4, cantidadDisponible);
		ps.setFloat(5, precio);

		resultado = ps.executeUpdate();
		connection.close();

		return resultado;

	}

	public List<FarmaciaDTO> buscarFarmacia(int idFarmacia, String nombreFarmacia, String descripcionFarmacia,
			int cantidadDisponible, float precio) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM farmacia WHERE ID LIKE ? AND Nombre LIKE ? AND Descripcion LIKE ? AND CantidadDisponible LIKE ? AND Precio >= ?;";

		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);

		ps.setString(1, "%" + idFarmacia + "%");
		ps.setString(2, "%" + nombreFarmacia + "%");
		ps.setString(3, "%" + descripcionFarmacia + "%");
		ps.setInt(4, cantidadDisponible);
		ps.setFloat(5, precio);

		ResultSet rs = ps.executeQuery();

		List<FarmaciaDTO> listaFarmacia = new ArrayList<>();

		while (rs.next()) {
			listaFarmacia.add(new FarmaciaDTO(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Descripcion"),
					rs.getInt("CantidadDisponible"), rs.getFloat("precio")));

		}
		return listaFarmacia;
	}
	
	public Integer actualizarFarmacia(int idFarmacia, String nombreFarmacia, String descripcionFarmacia,
			int cantidadDisponible, float precio) throws SQLException, ClassNotFoundException{

		String sql = "UPDATE farmacia "
				+ "SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END, "
				+ "Descripcion = CASE WHEN ? = '' THEN Descripcion ELSE ? END, "
				+ "CantidadDisponible = CASE WHEN ? = '' THEN CantidadDisponible ELSE ? END, "
				+ "Precio = CASE WHEN ? = '' THEN Precio ELSE ? END "
				+ "WHERE ID = ?;";

		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);

		ps.setString(1, nombreFarmacia);
		ps.setString(2, nombreFarmacia);
		
		ps.setString(3, descripcionFarmacia);
		ps.setString(4, descripcionFarmacia);
		
		ps.setInt(5, cantidadDisponible);
		ps.setInt(6, cantidadDisponible);
		
		
		ps.setFloat(7, precio);
		ps.setFloat(8, precio);
		
		ps.setInt(9, idFarmacia);
		resultado = ps.executeUpdate();
		
		
		return resultado;
		
	}
}
