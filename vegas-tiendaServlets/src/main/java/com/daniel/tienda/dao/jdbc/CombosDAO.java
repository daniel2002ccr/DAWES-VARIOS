package com.daniel.tienda.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dao.ICombosDAO;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.utils.DBUtils;

public class CombosDAO implements ICombosDAO {

	@Override
	public List<CombosDTO> recuperarComboProovedor() throws SQLException, ClassNotFoundException, NamingException {

		String sql = " SELECT Id_Proveedor, nombre FROM proveedores ORDER BY Id_Proveedor ";

		List<CombosDTO> listaProveedor = new ArrayList<>();

		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaProveedor.add(new CombosDTO(rs.getInt(1), rs.getString(2)));
		}
		c.close();
		return listaProveedor;
	}

	@Override
	public List<CombosDTO> recuperarComboCategoria()
			throws SQLException, ClassNotFoundException, NamingException {
		
String sql = " SELECT Id_Categoria, nombre FROM categorias ORDER BY Id_Categoria ";
		
		List<CombosDTO> listaCategorias = new ArrayList<>();
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql); 
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			listaCategorias.add(new CombosDTO(rs.getInt(1), rs.getString(2)));
		}
		c.close();
		return listaCategorias;
	}

	@Override
	public List<CombosDTO> recuperarComboPoblacion() throws SQLException, ClassNotFoundException, NamingException {

	String sql = " SELECT ID, nombre FROM poblacion ORDER BY ID";
	
	List<CombosDTO> listaPoblacion = new ArrayList<>();
	
	Connection c = DBUtils.conectaBBDD();
	PreparedStatement ps = c.prepareStatement(sql); 
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		listaPoblacion.add(new CombosDTO(rs.getInt(1), rs.getString(2)));
	}
		return listaPoblacion;
	}
}
