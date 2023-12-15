package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dao.jdbc.ProductosDAO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.negocio.IProductoServicio;

public class ProductoServicio implements IProductoServicio{

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String id_categoria, String id_proveedor)
			throws SQLException, ClassNotFoundException, NamingException {
		
		return new ProductosDAO().buscarProducto(id, nombre, descripcion, cantidadStock, precio, id_categoria, id_proveedor);
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		
		return new ProductosDAO().insertarProducto(nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
	}

}
