package com.daniel.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;



import com.daniel.tienda.dtos.ProveedorDTO;

public interface IProveedorDAO {

	public List<ProveedorDTO> recuperarComboProovedor() throws SQLException, ClassNotFoundException, NamingException;
}
