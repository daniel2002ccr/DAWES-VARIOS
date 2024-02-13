package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IClientesDAO;
import com.daniel.tienda.dao.hibernate.ClientesDAOHibernate;
import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.negocio.IClientesServicio;

@Component
public class ClientesServicio implements IClientesServicio{

	@Autowired
	@Qualifier("ClienteSpringJPA")
	IClientesDAO clientesDAO;
	@Override
	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return clientesDAO.buscarClientes(id, nombre, correo, poblacion, activo);
	}

	@Override
	public Integer insertarCliente(String nombre, String correo, String poblacion,  String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return clientesDAO.insertarCliente(nombre, correo, poblacion, activo);
	}

	@Override
	public Integer actualizarCliente(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return clientesDAO.actualizarCliente(id, nombre, correo, poblacion, activo);
	}

	@Override
	public Integer borrarCliente(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return clientesDAO.borrarCliente(id);
	}

}
