package com.daniel.tienda.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IPeticionesDAO;
import com.daniel.tienda.dtos.PeticionesDTO;
import com.daniel.tienda.utils.DBUtils;

@Component
public class PeticionesDAO implements IPeticionesDAO{

	@Override
	public List<PeticionesDTO> buscarPeticiones(String id, String id_cliente, String id_producto, String fecha,
			String cantidad, String estado) throws SQLException, ClassNotFoundException, NamingException {
		
		String sql = " SELECT p.id_Peticiones, p.id_Cliente, p.id_Producto, p.FechaAñadido, p.cantidad, p.estado FROM peticiones p "
				+ " INNER JOIN clientes cl ON p.id_Cliente = cl.id_Cliente "
				+ " INNER JOIN producto pr ON p.id_producto = pr.id_producto "
				+ " INNER JOIN estados e ON p.estado = e.estadoID WHERE p.id_Peticiones LIKE ? "
				+ " AND p.cantidad LIKE ? "
				+ " AND p.FechaAñadido LIKE ? ";
		
		if(!id_cliente.equals("")) {
		sql += "AND p.id_Cliente LIKE ? ";
		}
		
		if(!id_producto.equals("")) {
		sql += "AND p.id_Producto LIKE ? ";
		}
		if(!estado.equals("")) {
		sql += "AND p.estado LIKE ?";
		}
		
		Connection c = DBUtils.conectaBBDD();
		List <PeticionesDTO> listaPeticiones = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, "%" + id + "%");
		ps.setString(2, cantidad);
		ps.setString(3, fecha);
		
		//Con cliente
		if(!id_cliente.equals("")) {
		ps.setString(4, id_cliente);
		}
		//Con cliente y producto
		if(!id_cliente.equals("") && !id_producto.equals("")) {
			ps.setString(4, id_cliente);
			ps.setString(5, id_producto);
		}
		//Con cliente y estado
		if(!id_cliente.equals("") && !estado.equals("")) {
			ps.setString(4, id_cliente);
			ps.setString(5, estado);
		}
		//Con producto
		if(!id_producto.equals("")) {
			ps.setString(4, id_producto);
		}
		//Con producto y estado
		if(!id_producto.equals("") && !estado.equals("")) {
			ps.setString(4, id_producto);
			ps.setString(5, estado);
		}
		//Con todos 
		if(!id_cliente.equals("") && !id_producto.equals("") && !estado.equals("")) {
			ps.setString(4, id_cliente);
			ps.setString(5, id_producto);
			ps.setString(6, estado);
		}
		if(!estado.equals("")) {
			ps.setString(4, estado);
		}
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaPeticiones.add(new PeticionesDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
		}
		c.close();
		return listaPeticiones;
	}

	@Override
	public Integer insertarPeticion(String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarPeticion(String id, String id_cliente, String id_producto, String fecha, String cantidad,
			String estado) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarPeticion(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
