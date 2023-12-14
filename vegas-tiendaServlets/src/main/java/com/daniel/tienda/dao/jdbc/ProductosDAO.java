package com.daniel.tienda.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;


import com.daniel.tienda.dao.IProductosDAO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.utils.DBUtils;

public class ProductosDAO implements IProductosDAO {

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String cantidadStock,
			String precio ,String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		String sql = "SELECT p.ID_Producto, p.nombre, p.descripcion, p.precio, p.CantidadEnStock, c.ID_Categoria, pr.ID_Proveedor " +
	             " FROM productos p " +
	             " INNER JOIN categorias c ON p.ID_Categoria = c.ID_Categoria " +
	             " INNER JOIN proveedores pr ON p.ID_Proveedor = pr.ID_Proveedor " +
	             " WHERE p.ID_Producto LIKE ? AND p.nombre LIKE ? AND p.descripcion LIKE ? AND p.precio >= ? AND p.CantidadEnStock >= ? AND ID_Categoria = ? AND ID_Proveedor = ?";

		Connection c = DBUtils.conectaBBDD();
		List<ProductoDTO> listaProductos = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, cantidadStock);
		ps.setString(5, precio);
		ps.setString(6, id_categoria);
		ps.setString(7, id_proveedor);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProductos.add(new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
		}
		c.close();
		return listaProductos;
	}

}
