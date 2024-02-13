package com.daniel.tienda.dao.springjpa;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IProveedoresDAO;
import com.daniel.tienda.dtos.ProveedoresDTO;
import com.daniel.tienda.entities.ProveedoresEntity;
import com.daniel.tienda.repositories.ProveedoresRepository;

@Component("ProveedoresSpringJPA")
public class ProveedoresSpringJPA implements IProveedoresDAO{

	@Autowired
	ProveedoresRepository proveedores;
	
	@Override
	public List<ProveedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return proveedores.buscarProveedor(id, nombre, contacto, telefono, correo, direccion, Integer.parseInt(activo));
	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws SQLException, ClassNotFoundException, NamingException {

		ProveedoresEntity pe = new ProveedoresEntity(nombre, contacto, telefono, correo, direccion, Integer.parseInt(activo));
		proveedores.save(pe);
		return pe.getIdProveedor();
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws SQLException, ClassNotFoundException, NamingException {
		
		ProveedoresEntity pe = new ProveedoresEntity(Integer.parseInt(id),nombre, contacto, telefono, correo, direccion, Integer.parseInt(activo));
		proveedores.save(pe);
		return pe.getIdProveedor();
	}

	@Override
	public Integer borrarProveedor(String id) throws SQLException, ClassNotFoundException, NamingException {
		
		ProveedoresEntity pe = proveedores.findById(Integer.parseInt(id)).get();
		pe.setActivo(0);
		proveedores.save(pe);
		return pe.getIdProveedor();
	}

}
