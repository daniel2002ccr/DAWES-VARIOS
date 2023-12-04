package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.DepartamentosDTO;
import com.daniel.hospital.dtos.HabitacionDTO;
import com.daniel.hospital.utils.DBUtils;

public class DepartamentosModelo {

	public Integer crearDepartamento(int idDepartamento, String nombre, String descripcion, int activo) throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO departamentos (ID, Nombre, Descripcion, Activo) VALUES (?, ?, ?, ?)";
		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1, idDepartamento);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setInt(4, activo);
		
		resultado = ps.executeUpdate();
		connection.close();
		
		
		return resultado;
		
	}
	
	public List <DepartamentosDTO> buscarDepartamentos (int idDepartamento, String nombre, String descripcion, int activo) throws ClassNotFoundException, SQLException {
		
		String query = "SELECT * FROM departamentos WHERE ID LIKE ? AND Nombre LIKE ? AND Descripcion LIKE ? AND Activo >= ?;";
		
		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);
		
		ps.setString(1,  "%" + idDepartamento + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setInt(4, activo);
		
		ResultSet rs = ps.executeQuery();
		
		
		List<DepartamentosDTO> listaDepartamentos = new ArrayList<>();
		
		while (rs.next()) {
			listaDepartamentos.add(new DepartamentosDTO(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getInt("Activo")));
			
		}
		
		return listaDepartamentos;
		
	}
	
	public Integer actualizarDepartamentos(int idDepartamento, String nombre, String descripcion, int activo) throws SQLException, ClassNotFoundException{

		String sql = "UPDATE departamentos "
				+ "SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END, "
				+ "Descripcion = CASE WHEN ? = '' THEN Descripcion ELSE ? END, "
				+ "Activo = ?  "
				+ "WHERE ID = ?;";

		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		
		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);
		
		ps.setString(3, descripcion);
		ps.setString(4, descripcion);
		
		ps.setInt(5, activo);
	
		
		
		ps.setInt(6, idDepartamento);
		
//		System.out.println(ps.toString());
		resultado = ps.executeUpdate();
		
		
		return resultado;
		
	}
	public Integer borrarDepartamentos(int idDepartamento, int activo) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE departamentos SET Activo =  0  WHERE ID = ?";

		
		Connection con = DBUtils.conexionBBDD();
		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, idDepartamento);
		int resultado = ps.executeUpdate();
		return resultado;
	}
		
}
