package com.daniel.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.PeticionesDTO;

public interface IPeticionesServicio {

	public List<PeticionesDTO> buscarPeticiones(String id, String id_cliente, String id_producto, String fecha, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException;

	public Integer insertarPeticion(String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException;

	public Integer actualizarPeticion(String id, String id_cliente, String id_producto, String fecha, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException;

	public Integer borrarPeticion(String id) throws SQLException, ClassNotFoundException, NamingException;
}
