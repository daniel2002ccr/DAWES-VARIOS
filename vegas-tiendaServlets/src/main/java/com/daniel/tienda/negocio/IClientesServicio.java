package com.daniel.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.ClientesDTO;

public interface IClientesServicio {

	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException;

	public Integer insertarCliente(String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException;

	public Integer actualizarCliente(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException;

	public Integer borrarCliente(String id) throws SQLException, ClassNotFoundException, NamingException;
}
