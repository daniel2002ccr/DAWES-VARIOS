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
		
		String sql = " SELECT p.id_Peticiones, p.ID_Cliente, cl.Nombre, p.ID_Producto, pr.Nombre, p.FechaAñadido, p.cantidad, p.Estado, e.NombreEstado FROM peticiones p "
				+ " INNER JOIN clientes cl ON p.id_Cliente = cl.id_Cliente "
				+ " INNER JOIN productos pr ON p.id_producto = pr.id_producto "
				+ " INNER JOIN estadospedidos e ON p.estado = e.estadoID WHERE p.id_Peticiones LIKE ? "
				+ " AND p.cantidad LIKE ? "
				+ " AND p.FechaAñadido >= ? ";
		
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
		ps.setString(2, "%" + cantidad + "%");
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
//			listaPeticiones.add(new PeticionesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
		}
		c.close();
		return listaPeticiones;
	}

	@Override
	public Integer insertarPeticion(String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException {

		String sql = "INSERT INTO peticiones (ID_Cliente, ID_Producto, cantidad, estado) VALUES (?, ?, ?, ?)";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, id_cliente);
		ps.setString(2, id_producto);
		ps.setString(3, cantidad);
		ps.setString(4, estado);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		
		
		return resultado;
	}

	@Override
	public Integer actualizarPeticion(String id, String id_cliente, String id_producto, String cantidad,
			String estado) throws SQLException, ClassNotFoundException, NamingException {

		String sql = "UPDATE peticiones SET ID_Cliente = ?, ID_Producto = ?, Cantidad = ?, Estado = ? WHERE id_Peticiones = ?";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, id_cliente);
		ps.setString(2, id_producto);
		ps.setString(3, cantidad);
		ps.setString(4, estado);
		ps.setString(5, id);
		
		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

	@Override
	public Integer borrarPeticion(String id) throws SQLException, ClassNotFoundException, NamingException {

		String sql = "UPDATE peticiones SET  Estado = 5 WHERE id_Peticiones = ?";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

	
}
