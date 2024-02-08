package com.daniel.tienda.dao.springjpa;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.ICategoriaDAO;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.entities.CategoriaEntity;
import com.daniel.tienda.repositories.CategoriaRepository;

@Component("CategoriaSpringJPA")
public class CategoriaSpringJPA implements ICategoriaDAO{

	@Autowired
	CategoriaRepository categoria;
	@Override
	public List<CategoriaDTO> buscarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return categoria.buscarCategoria(id, nombre, descripcion, Integer.parseInt(activo));
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		CategoriaEntity ce = new CategoriaEntity(nombre, descripcion, Integer.parseInt(activo));
		categoria.save(ce);
		return ce.getId();
	}

	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {

		CategoriaEntity ce = new CategoriaEntity(Integer.parseInt(id), nombre, descripcion, Integer.parseInt(activo));
		categoria.save(ce);
		return ce.getId();
	}

	@Override
	public Integer borrarCategoria(String id) throws SQLException, ClassNotFoundException, NamingException {

		CategoriaEntity ce = categoria.findById(Integer.parseInt(id)).get();
		ce.setActivo(0);
		categoria.save(ce);
		return ce.getId();
	}

}
