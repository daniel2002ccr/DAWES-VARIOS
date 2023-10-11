package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.FacturacionDTO;
import com.daniel.hospital.utils.DBUtils;

public class FacturacionModelo {

	public Integer crearFacturacion(String pacienteNombre, String fecha, float monto, String estado)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO facturacion (PacienteID, Fecha, Monto, EstadoID) VALUES ((SELECT p.id FROM pacientes p WHERE p.nombre = ?), ?, ?,"
				+ "(SELECT e.id FROM estadofacturacion e WHERE e.estado = ?))";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, pacienteNombre);
		ps.setString(2, fecha);
		ps.setFloat(3, monto);
		ps.setString(4, estado);

		resultado = ps.executeUpdate();
		connection.close();

		return resultado;

	}

	public List<FacturacionDTO> buscarFacturacion(int id, String pacienteNombre, String fecha, float monto, String estado) throws ClassNotFoundException, SQLException {
	    String sql = "SELECT f.ID, p.Nombre as PacienteNombre, f.Fecha, f.Monto, e.Estado " +
	                 "FROM facturacion f " +
	                 "INNER JOIN pacientes p ON f.PacienteID = p.ID " +
	                 "INNER JOIN estadofacturacion e ON f.EstadoID = e.ID " +
	                 "WHERE f.ID LIKE ? AND p.Nombre LIKE ? AND f.Fecha LIKE ? AND f.Monto LIKE ? AND e.Estado LIKE ?";

	    Connection conexionBBDD = DBUtils.conexionBBDD();
	    PreparedStatement ps = conexionBBDD.prepareStatement(sql);

	    ps.setString(1, "%" + id + "%");
	    ps.setString(2, "%" + pacienteNombre + "%");
	    ps.setString(3, "%" + fecha + "%");
	    ps.setString(4, "%" + monto + "%");
	    ps.setString(5, "%" + estado + "%");

	    ResultSet rs = ps.executeQuery();
	    List<FacturacionDTO> listaFacturacion = new ArrayList<>();

	    while (rs.next()) {
	        listaFacturacion.add(new FacturacionDTO(rs.getInt("ID"),
	                rs.getString("PacienteNombre"),
	                rs.getString("Fecha"),
	                rs.getFloat("Monto"),
	                rs.getString("Estado")));
	    }

	    return listaFacturacion;
	}
	
public Integer actualizaFacturacion (int id, String pacienteNombre, String fecha, float monto, String estado)  throws ClassNotFoundException, SQLException{
		
		
	String sql = "UPDATE facturacion SET " +
            "pacienteID = IF(? = '', pacienteID, (SELECT p.id FROM pacientes p WHERE p.nombre = ?)), " +
            "Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END, " +
            "Monto = CASE WHEN ? = '' THEN Monto ELSE ? END, " +
            "EstadoID = IF(? = '', EstadoID, (SELECT e.id FROM estadofacturacion e WHERE e.estado = ?)) " +
            "WHERE ID = ?;";


		
		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);
		
		ps.setString(1, pacienteNombre);
		ps.setString(2, pacienteNombre);
		ps.setString(3, fecha);
		ps.setString(4, fecha);
		ps.setFloat(5, monto);
		ps.setFloat(6, monto);
		ps.setString(7, estado);
		ps.setString(8, estado);
		ps.setInt(9, id);
		
		
		resultado = ps.executeUpdate();
		return resultado;
		
	}
		
}
