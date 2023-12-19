package com.daniel.tienda.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IProductosDAO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.utils.DBUtils;

@Component
public class ProductosDAO implements IProductosDAO {

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			 String cantidadStock,String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		String sql = "SELECT p.ID_Producto, p.nombre, p.descripcion, p.precio, p.CantidadEnStock, p.ID_Categoria, p.ID_Proveedor " +
	             " FROM productos p " +
	             " INNER JOIN categorias c ON p.ID_Categoria = c.ID_Categoria " +
	             " INNER JOIN proveedores pr ON p.ID_Proveedor = pr.ID_Proveedor " +
	             " WHERE p.ID_Producto LIKE ? AND p.nombre LIKE ? AND p.descripcion LIKE ? AND p.precio >= ? "
	             + " AND p.CantidadEnStock >= ? AND p.ID_Categoria LIKE ? " + "AND p.ID_Proveedor LIKE ? ";

		Connection c = DBUtils.conectaBBDD();
		List<ProductoDTO> listaProductos = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, cantidadStock);
		ps.setString(5, precio);
		ps.setString(6, "%" + id_categoria + "%");
		ps.setString(7,  "%" + id_proveedor + "%");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProductos.add(new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
		}
		c.close();
		return listaProductos;
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, String precio,
			 String cantidadStock,String id_categoria, String id_proveedor)
			throws SQLException, ClassNotFoundException, NamingException {
		String sql = " INSERT INTO productos (nombre, descripcion, precio, cantidadEnStock, Id_Categoria, Id_Proveedor) VALUES (?, ?, ?, ?, ?, ?)";
		
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, precio);
		ps.setString(4, cantidadStock);
		ps.setString(5, id_categoria);
		ps.setString(6, id_proveedor);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		
		return resultado;
	}

	@Override
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
			String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		
		String sql = " UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, CantidadEnStock = ?, id_categoria = ?, id_proveedor = ? WHERE id_producto = ? ";
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, precio);
		ps.setString(4, cantidadStock);
		ps.setString(5, id_categoria);
		ps.setString(6, id_proveedor);
		ps.setString(7, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

}
