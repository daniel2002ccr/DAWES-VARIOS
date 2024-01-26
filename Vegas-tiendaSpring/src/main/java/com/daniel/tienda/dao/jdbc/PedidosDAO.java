package com.daniel.tienda.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IPedidosDAO;
import com.daniel.tienda.dtos.PedidosDTO;
import com.daniel.tienda.utils.DBUtils;

@Component
public class PedidosDAO implements IPedidosDAO {

	@Override
	public List<PedidosDTO> buscarPedidos(String id, String id_cliente, String fecha, String estado)
			throws SQLException, ClassNotFoundException, NamingException {

		String sql = " SELECT p.ID_Pedido, p.ID_Cliente, cl.Nombre, d.Id_Producto, pr.Nombre,  p.FechaPedido, p.EstadoID, e.NombreEstado, d.Id_Detalle, d.Cantidad, d.PrecioUnitario  FROM pedidos p"
				+ " INNER JOIN clientes cl ON p.ID_Cliente = cl.id_Cliente "
				+ " INNER JOIN estadospedidos e ON p.EstadoID = e.estadoID "
				+ " INNER JOIN detalles_pedido d ON p.ID_Pedido = d.ID_Pedido "
				+ " INNER JOIN productos pr ON d.ID_Producto = pr.ID_Producto "
				+ " WHERE p.ID_Pedido LIKE ? AND p.FechaPedido >= ? ";

		if (!id_cliente.equals("")) {
			sql += "AND p.id_Cliente LIKE ?";
		}
		if (!estado.equals("")) {
			sql += "AND p.estado LIKE ?";
		}

		Connection c = DBUtils.conectaBBDD();
		List<PedidosDTO> listaPedidos = new ArrayList<>();
		PreparedStatement ps = c.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, fecha);

		// Con cliente
		if (!id_cliente.equals("")) {
			ps.setString(3, id_cliente);
		}
		// Con todos
		if (!id_cliente.equals("") && !estado.equals("")) {
			ps.setString(3, id_cliente);
			ps.setString(4, estado);
		}
		
		//Con estado 
		if(!estado.equals("")) {
			ps.setString(3, estado);
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaPedidos.add(new PedidosDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getDouble(11)));
		}

		return listaPedidos;
	}

	@Override
	public Integer actualizarPedidos(String id, String id_cliente, String id_producto, String id_detalle, String cantidad, String precio,
			String estado) throws SQLException, ClassNotFoundException, NamingException {

		String sql = "UPDATE pedidos SET ID_Cliente = ?, EstadoID = ? WHERE ID_Pedido = ?";
		String sql2 = "UPDATE detalles_pedido SET ID_Producto = ?, Cantidad = ? ,PrecioUnitario = ? WHERE ID_Detalle = ?";

		Connection c = DBUtils.conectaBBDD();

		c.setAutoCommit(false);

		PreparedStatement ps1 = c.prepareStatement(sql);
		ps1.setString(1, id_cliente);
		ps1.setString(2, estado);
		ps1.setString(3, id);

		PreparedStatement ps2 = c.prepareStatement(sql2);
		ps2.setString(1, id_producto);
		ps2.setString(2, cantidad);
		ps2.setString(3, precio);
		ps2.setString(4, id_detalle);
		

		Integer resultado1 = ps1.executeUpdate();
		Integer resultado2 = ps2.executeUpdate();
		c.commit();

		return resultado1 + resultado2;
	}

}
