package com.daniel.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.daniel.tienda.dtos.CombosDTO;

public interface ICombosDAO {
	public List<CombosDTO> recuperarComboCategoria() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboProovedor() throws SQLException, ClassNotFoundException, NamingException;
}
