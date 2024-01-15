package com.daniel.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.CombosDTO;

public interface ICombosServicio {

	public List<CombosDTO> recuperarComboCategoria() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboProveedores() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboPoblacion() throws SQLException, ClassNotFoundException, NamingException;
}
