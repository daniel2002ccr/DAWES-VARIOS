package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.MedicosDTO;
import com.daniel.hospital.utils.DBUtils;

public class MedicosModelo {
	public Integer crearMedico( String nombre, String apellido, String especialidad, String licencia,
			String telefono, String correo) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO medicos (Nombre, Apellido, Especialidad, LicenciaMedica, Telefono, CorreoElectronico) VALUES (?, ?, ?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		
		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, especialidad);
		ps.setString(4, licencia);
		ps.setString(5, telefono);
		ps.setString(6, correo);

		resultado = ps.executeUpdate();
		connection.close();

		return resultado;
	}

	public List<MedicosDTO> buscarMedico(int idMedico, String nombre, String apellido, String especialidad,
			String licencia, String telefono, String correo) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM medicos WHERE ID LIKE ? AND Nombre LIKE ? AND Apellido LIKE ? AND Especialidad LIKE ? AND LicenciaMedica LIKE ? AND Telefono LIKE ? AND CorreoElectronico LIKE ?;";

		Connection conexionBBDD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBBDD.prepareStatement(query);

		ps.setString(1, "%" + idMedico + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + apellido + "%");
		ps.setString(4, "%" + especialidad + "%");
		ps.setString(5, "%" + licencia + "%");
		ps.setString(6, "%" + telefono + "%");
		ps.setString(7, "%" + correo + "%");

//	System.out.println(ps.toString());
		ResultSet rs = ps.executeQuery();

		List<MedicosDTO> listaMedicos = new ArrayList<>();

		while (rs.next()) {
			listaMedicos.add(new MedicosDTO(rs.getInt("ID"), rs.getString("Nombre"), rs.getString("Apellido"),
					rs.getString("Especialidad"), rs.getString("LicenciaMedica"), rs.getString("Telefono"), rs.getString("CorreoElectronico")));

		}
		return listaMedicos;

	}

	public Integer actualizarMedicos(int idMedico, String nombre, String apellido, String especialidad,
			String licencia, String telefono, String correo) 
			throws SQLException, ClassNotFoundException {

	    String sql = "UPDATE medicos SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END, " +
                "Apellido = CASE WHEN ? = '' THEN Apellido ELSE ? END, " +
                "Especialidad = CASE WHEN ? = '' THEN Especialidad ELSE ? END, " +
                "LicenciaMedica = CASE WHEN ? = '' THEN LicenciaMedica ELSE ? END, " +
                "Telefono = CASE WHEN ? = '' THEN Telefono ELSE ? END, " +
                "CorreoElectronico = CASE WHEN ? = '' THEN CorreoElectronico ELSE ? END " +
                "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
        ps.setString(2, nombre);

        ps.setString(3, apellido);
        ps.setString(4, apellido);

        ps.setString(5, especialidad);
        ps.setString(6, especialidad);

        ps.setString(7, licencia);
        ps.setString(8, licencia);

        ps.setString(9, telefono);
        ps.setString(10, telefono);

        ps.setString(11, correo);
        ps.setString(12, correo);

        ps.setInt(13, idMedico);
		resultado = ps.executeUpdate();
		return resultado;

	}
}
