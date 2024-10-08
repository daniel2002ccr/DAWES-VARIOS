package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.daniel.tienda.dao.IProveedoresDAO;
import com.daniel.tienda.dao.jdbc.ProveedoresDAO;
import com.daniel.tienda.dtos.ProveedoresDTO;
import com.daniel.tienda.negocio.IProveedoresServicio;

@Component
public class ProveedoresServicio implements IProveedoresServicio{


	@Autowired
	@Qualifier("ProveedoresSpringJPA")
	IProveedoresDAO proveedor;
	
	@Override
	public List<ProveedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return proveedor.buscarProveedores(id, nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return proveedor.insertarProveedor(nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return proveedor.actualizarProveedor(id, nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer borrarProveedor(String id) throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return proveedor.borrarProveedor(id);
	}

}
