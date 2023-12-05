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

	
}
