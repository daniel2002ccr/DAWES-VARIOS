package com.daniel.tienda.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dao.IProductosDAO;
import com.daniel.tienda.dtos.ProductoDTO;

public class ProductosDAOHibernate implements IProductosDAO{

	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String id_categoria, String id_proveedor)
			throws SQLException, ClassNotFoundException, NamingException {

		String jpql = " SELECT new ";
		return null;
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
			String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
