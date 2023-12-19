package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.ICategoriaDAO;
import com.daniel.tienda.dao.jdbc.CategoriaDAOJdbc;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.negocio.ICategoriaServicio;

@Component
public class CategoriaServicio implements ICategoriaServicio{
	
	@Autowired
	ICategoriaDAO categoriaDAO;

	@Override
	public List<CategoriaDTO> buscarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		return categoriaDAO.buscarCategoria(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		return categoriaDAO.insertarCategoria(nombre, descripcion, activo);
	}

	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return categoriaDAO.actualizarCategoria(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategoria(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return categoriaDAO.borrarCategoria(id);
	}

	@Override
	public List<CategoriaDTO> recuperarComboCategoria() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return categoriaDAO.recuperarComboCategoria();
	}

	
}
