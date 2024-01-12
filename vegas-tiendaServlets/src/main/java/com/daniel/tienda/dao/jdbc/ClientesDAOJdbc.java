package com.daniel.tienda.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dao.IClientesDAO;
import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.utils.DBUtils;

public class ClientesDAOJdbc implements IClientesDAO{

	@Override
	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		String sql;
		
		if(poblacion.equals("")) {
		 sql = "SELECT c.ID_Cliente, c.Nombre, c.CorreoElectronico, p.Nombre, c.activo "
				+ "	FROM clientes c "
				+ "	JOIN poblacion p ON c.ID_Poblacion = p.ID "
				+ "	WHERE c.ID_Cliente LIKE ? "
				+ "	AND c.Nombre LIKE ?  "
				+ " AND c.CorreoElectronico LIKE ? "
				+ " AND c.activo = ? ";
	} else {
		 sql = "SELECT c.ID_Cliente, c.Nombre, c.CorreoElectronico, p.Nombre, c.activo "
				+ "	FROM clientes c "
				+ "	JOIN poblacion p ON c.ID_Poblacion = p.ID "
				+ "	WHERE c.ID_Cliente LIKE ? "
				+ "	AND c.Nombre LIKE ?  "
				+ " AND c.CorreoElectronico LIKE ? "
				+ " AND c.ID_Poblacion = ? "
				+ " AND c.activo = ? ";
	}
		
		
		Connection c = DBUtils.conectaBBDD();
		List <ClientesDTO> listaClientes = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + correo + "%");
		
		if (poblacion.equals("")) {
			ps.setString(4, activo);
		} else {
			ps.setString(4, poblacion);
			ps.setString(5, activo);
		}

		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaClientes.add(new ClientesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getInt(5)));
		}
		c.close();
		return listaClientes;
	}

	@Override
	public Integer insertarCliente(String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		String sql = " INSERT INTO clientes (nombre, CorreoElectronico, Id_Poblacion, activo) VALUES (?, ?, ?, ?)";
		
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, nombre);
		ps.setString(2, correo);
		ps.setString(3, poblacion);
		ps.setString(4, activo);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		
		return resultado;
	}

	@Override
	public Integer actualizarCliente(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		String sql = "UPDATE clientes SET nombre = ?, CorreoElectronico = ?, Id_Poblacion = ?, activo = ? WHERE id_cliente = ? ";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, nombre);
		ps.setString(2, correo);
		ps.setString(3, poblacion);
		ps.setString(4, activo);
		ps.setString(5, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

	@Override
	public Integer borrarCliente(String id) throws SQLException, ClassNotFoundException, NamingException {
		String sql = "UPDATE clientes SET activo = 0 WHERE id_cliente = ?";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}
	}



