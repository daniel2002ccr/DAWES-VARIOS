package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dao.jdbc.CategoriaDAOJdbc;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.negocio.ICategoriaServicio;

public class CategoriaServicio implements ICategoriaServicio{

	@Override
	public List<CategoriaDTO> buscarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		return new CategoriaDAOJdbc().buscarCategoria(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		return new CategoriaDAOJdbc().insertarCategoria(nombre, descripcion, activo);
	}

	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return new CategoriaDAOJdbc().actualizarCategoria(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategoria(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
