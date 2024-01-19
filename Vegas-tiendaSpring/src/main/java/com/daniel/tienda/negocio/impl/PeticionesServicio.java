package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.jdbc.PeticionesDAO;
import com.daniel.tienda.dtos.PeticionesDTO;
import com.daniel.tienda.negocio.IPeticionesServicio;

@Component
public class PeticionesServicio implements IPeticionesServicio{

	@Autowired
	PeticionesDAO peticionesDAO;
	
	@Override
	public List<PeticionesDTO> buscarPeticiones(String id, String id_cliente, String id_producto, String fecha,
			String cantidad, String estado) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return peticionesDAO.buscarPeticiones(id, id_cliente, id_producto, fecha, cantidad, estado);
	}

	@Override
	public Integer insertarPeticion(String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return peticionesDAO.insertarPeticion(id_cliente, id_producto, cantidad, estado);
	}

	@Override
	public Integer actualizarPeticion(String id, String id_cliente, String id_producto, String cantidad,
			String estado) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return peticionesDAO.actualizarPeticion(id, id_cliente, id_producto, cantidad, estado);
	}

	@Override
	public Integer borrarPeticion(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return peticionesDAO.borrarPeticion(id);
	}

}
