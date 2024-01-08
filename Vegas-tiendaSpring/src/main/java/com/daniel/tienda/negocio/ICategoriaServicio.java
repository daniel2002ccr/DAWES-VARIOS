package com.daniel.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.dtos.CombosDTO;

public interface ICategoriaServicio {

	public List<CategoriaDTO> buscarCategoria(String id, String nombre, String descripcion, String activo) throws SQLException, ClassNotFoundException, NamingException;
	public Integer insertarCategoria(String nombre, String descripcion, String activo)throws SQLException, ClassNotFoundException, NamingException;
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)throws SQLException, ClassNotFoundException, NamingException;
	public Integer borrarCategoria(String id)throws SQLException, ClassNotFoundException, NamingException;
	

}
