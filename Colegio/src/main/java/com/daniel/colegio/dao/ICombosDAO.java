package com.daniel.colegio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.colegio.dtos.ComboDTO;

public interface ICombosDAO {

	public List<ComboDTO> recuperaCombosMunicipio() throws ClassNotFoundException, SQLException, NamingException;
}
