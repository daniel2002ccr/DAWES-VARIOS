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
		
		String sql = " SELECT cl.Id_Cliente, cl.nombre, cl.correo, cl.Id_Poblacion, cl.activo FROM clientes cl "
				+ " INNER JOIN poblacion p ON p.id = cl.Id_Poblacion "
				+ " WHERE cl.Id_Cliente LIKE ? AND cl.nombre LIKE ? AND cl.correo LIKE ? AND cl.IdPoblacion LIKE ? AND cl.activo = ?";
		
		
		Connection c = DBUtils.conectaBBDD();
		List <ClientesDTO> listaClientes = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + correo + "%");
		ps.setString(4, "%" + poblacion + "%");
		ps.setString(5, activo);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaClientes.add(new ClientesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),  rs.getInt(5)));
		}
		c.close();
		return listaClientes;
	}

	@Override
	public Integer insertarCliente(String nombre, String correo, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarCliente(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarCliente(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
