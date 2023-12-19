package com.daniel.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.ProductoDTO;

public interface IProductosDAO {

	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String id_categoria, String id_proveedor)
			throws SQLException, ClassNotFoundException, NamingException;

	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException;


public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
		String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException;

}
