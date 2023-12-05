package com.daniel.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.CategoriaDTO;



public interface ICategoriaDAO {

	public List<CategoriaDTO> buscarCategoria(String id, String nombre, String descripcion, String activo) throws SQLException, ClassNotFoundException, NamingException;
}
