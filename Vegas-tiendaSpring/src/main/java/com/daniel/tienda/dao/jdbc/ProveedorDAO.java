package com.daniel.tienda.dao.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IProveedorDAO;
import com.daniel.tienda.dtos.ProveedorDTO;
import com.daniel.tienda.utils.DBUtils;

@Component
public class ProveedorDAO implements IProveedorDAO{

	@Override
	public List<ProveedorDTO> recuperarComboProovedor()
			throws SQLException, ClassNotFoundException, NamingException {
		
String sql = " SELECT Id_Proveedor, nombre FROM proveedores ORDER BY Id_Proveedor ";
		
		List<ProveedorDTO> listaProveedor = new ArrayList<>();
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			listaProveedor.add(new ProveedorDTO(rs.getInt(1), rs.getString(2)));
		}
		c.close();
		return listaProveedor;
	}
	
}
