package com.daniel.colegio.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.colegio.dao.ICombosDAO;
import com.daniel.colegio.dtos.ComboDTO;
import com.daniel.colegio.utils.DBUtils;

@Component("combojdbc")
public class CombosDAOImpl implements ICombosDAO{

	@Override
	public List<ComboDTO> recuperaCombosMunicipio() throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = " SELECT id_municipio, nombre FROM municipios ORDER BY nombre ";
		
		List<ComboDTO> listaMunicipios = new ArrayList<>();
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			listaMunicipios.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		c.close();
		return listaMunicipios;
	}

}
