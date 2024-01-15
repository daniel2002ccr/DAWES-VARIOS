package com.daniel.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.ProveedoresDTO;

public interface IProveedoresServicio {

	public List<ProveedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono, String correo, String direccion,  String activo) throws SQLException, ClassNotFoundException, NamingException;
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,  String activo)throws SQLException, ClassNotFoundException, NamingException;
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo, String direccion,  String activo)throws SQLException, ClassNotFoundException, NamingException;
	public Integer borrarProveedor(String id)throws SQLException, ClassNotFoundException, NamingException;
}
