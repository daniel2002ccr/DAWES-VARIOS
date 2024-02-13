package com.daniel.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.daniel.tienda.dtos.CombosDTO;

public interface ICombosDAO {
	public List<CombosDTO> recuperarComboCategoria() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboProveedores() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboPoblacion() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboCliente() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboProducto() throws SQLException, ClassNotFoundException, NamingException;
	public List<CombosDTO> recuperarComboEstado() throws SQLException, ClassNotFoundException, NamingException;
}
