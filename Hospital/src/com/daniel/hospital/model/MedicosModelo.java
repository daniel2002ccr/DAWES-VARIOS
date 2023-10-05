package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.daniel.hospital.utils.DBUtils;

public class MedicosModelo {
public Integer crearMedico (int idMedico, String nombre, String apellido, String especialidad, String licencia,
		String telefono, String correo) throws ClassNotFoundException, SQLException{
		
		String sql = "INSERT INTO medicos (ID, Nombre, Estado, CostoPorDia) VALUES (?, ?, ?, ?)";
		
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
}
