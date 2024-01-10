package com.daniel.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.daniel.tienda.dtos.ClientesDTO;

public interface IClientesDAO {

	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo) throws SQLException, ClassNotFoundException, NamingException;
	public Integer insertarCliente(String nombre, String correo, String activo)throws SQLException, ClassNotFoundException, NamingException;
	public Integer actualizarCliente(String id, String nombre, String correo, String poblacion, String activo)throws SQLException, ClassNotFoundException, NamingException;
	public Integer borrarCliente(String id)throws SQLException, ClassNotFoundException, NamingException;
}
