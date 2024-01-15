package com.daniel.tienda.dao.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IProveedoresDAO;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.dtos.ProveedoresDTO;
import com.daniel.tienda.utils.DBUtils;

@Component
public class ProveedoresDAO implements IProveedoresDAO{

	@Override
	public List<ProveedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {

		String sql = "SELECT p.Id_Proveedor, p.nombre, p.contacto, p.telefono, p.CorreoElectronico, p.direccion, p.activo "
	            + "FROM proveedores p "
	            + "WHERE p.Id_Proveedor LIKE ? AND p.nombre LIKE ? AND p.contacto LIKE ? AND p.telefono LIKE ? "
	            + "AND p.CorreoElectronico LIKE ? AND p.direccion LIKE ? AND p.activo = ? ";

		
		Connection c = DBUtils.conectaBBDD();
		List<ProveedoresDTO> listaProveedores = new ArrayList<>();
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + contacto + "%");
		ps.setString(4, "%" + telefono + "%");
		ps.setString(5, "%" + correo + "%");
		ps.setString(6, "%" + direccion + "%");
		ps.setString(7, activo);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProveedores.add(new ProveedoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) ,rs.getString(6), rs.getInt(7)));
		}
		c.close();
		return listaProveedores;
	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws SQLException, ClassNotFoundException, NamingException {
		String sql = " INSERT INTO proveedores (nombre, contacto, telefono, CorreoElectronico, direccion, activo) VALUES (?, ?, ?, ?, ?, ?)";
		
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, contacto);
		ps.setString(3, telefono);
		ps.setString(4, correo);
		ps.setString(5, direccion);
		ps.setString(6, activo);
		
		Integer resultado = ps.executeUpdate();
		c.close();

		
		return resultado;
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws SQLException, ClassNotFoundException, NamingException {
		
		String sql = " UPDATE proveedores "
	            + " SET nombre = ?, contacto = ?, telefono = ?, CorreoElectronico = ?, direccion = ?, activo = ? "
	            + " WHERE Id_Proveedor = ? ";

		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, nombre);
		ps.setString(2, contacto);
		ps.setString(3, telefono);
		ps.setString(4, correo);
		ps.setString(5, direccion);
		ps.setString(6, activo);
		ps.setString(7, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		
		return resultado;
	}

	@Override
	public Integer borrarProveedor(String id) throws SQLException, ClassNotFoundException, NamingException {
		String sql = " UPDATE proveedores SET activo = 0 WHERE ID_Proveedor = ?";

		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

}
