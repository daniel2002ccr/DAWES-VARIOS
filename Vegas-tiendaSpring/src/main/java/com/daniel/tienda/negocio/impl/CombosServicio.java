package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.ICombosDAO;
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.negocio.ICombosServicio;

@Component
public class CombosServicio implements ICombosServicio {

	@Autowired
	ICombosDAO combosDAO;
	@Override
	public List<CombosDTO> recuperarComboCategoria() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return combosDAO.recuperarComboCategoria();
	}

	@Override
	public List<CombosDTO> recuperarComboProveedores() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return combosDAO.recuperarComboProovedor();
	}

	@Override
	public List<CombosDTO> recuperarComboPoblacion() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return combosDAO.recuperarComboPoblacion();
	}

}
