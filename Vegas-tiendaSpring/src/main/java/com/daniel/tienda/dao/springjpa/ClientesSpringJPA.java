package com.daniel.tienda.dao.springjpa;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IClientesDAO;
import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.entities.ClienteEntity;
import com.daniel.tienda.repositories.ClienteRepository;
import com.daniel.tienda.repositories.PoblacionRepository;

@Component("ClienteSpringJPA")
public class ClientesSpringJPA implements IClientesDAO{

	@Autowired
	PoblacionRepository poblacion;
	@Autowired
	ClienteRepository cliente;
	@Override
	public List<ClientesDTO> buscarClientes(String idCliente, String nombre, String correoElectronico,
			String nombrePoblacion, String activo) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return cliente.buscarCliente(idCliente, nombre, correoElectronico, nombrePoblacion, Integer.parseInt(activo));
	}

	@Override
	public Integer insertarCliente(String nombre, String correoElectronico, String nombrePoblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		ClienteEntity ce = new ClienteEntity(nombre, correoElectronico, poblacion.findById(Integer.parseInt(nombrePoblacion)).get(), Integer.parseInt(activo));
		cliente.save(ce);
		return ce.getId();
	}

	@Override
	public Integer actualizarCliente(String id, String nombre, String correo, String nombrePoblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {

		ClienteEntity ce = new ClienteEntity(Integer.parseInt(id), nombre, correo, poblacion.findById(Integer.parseInt(nombrePoblacion)).get(), Integer.parseInt(activo));
		cliente.save(ce);
		return ce.getId();
	}

	@Override
	public Integer borrarCliente(String id) throws SQLException, ClassNotFoundException, NamingException {
		
		ClienteEntity ce = cliente.findById(Integer.parseInt(id)).get();
		ce.setActivo(0);
		cliente.save(ce);
		return ce.getId();
	}

}
