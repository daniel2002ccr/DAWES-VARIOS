package com.daniel.tienda.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.ICategoriaDAO;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.utils.DBUtils;

@Component
public class CategoriaDAOJdbc implements ICategoriaDAO {

	@Override
	public List<CategoriaDTO> buscarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {

		String sql = " SELECT c.ID_Categoria, c.nombre, c.descripcion, c.activo FROM categorias c "
				+ " WHERE c.ID_Categoria LIKE ? AND c.nombre LIKE ? AND c.descripcion LIKE ? " + " AND c.activo = ?";

		Connection c = DBUtils.conectaBBDD();
		List<CategoriaDTO> listaCategoria = new ArrayList<>();

		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, activo);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			listaCategoria.add(new CategoriaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		c.close();
		return listaCategoria;
	}

	@Override
	public Integer insertarCategoria(String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		String sql = " INSERT INTO categorias (nombre, descripcion, activo) VALUES (?, ?, ?)";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		
		return resultado;
	}



	@Override
	public Integer actualizarCategoria(String id, String nombre, String descripcion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
			String sql = " UPDATE categorias SET nombre = ?, descripcion = ?, activo = ? WHERE ID_Categoria = ?";
			
			Connection c = DBUtils.conectaBBDD();
			PreparedStatement ps = c.prepareStatement(sql);
			
			
			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setString(3, activo);
			ps.setString(4, id);
		
			Integer resultado = ps.executeUpdate();
			c.close();
			return resultado;
	}

	@Override
	public Integer borrarCategoria(String id) throws SQLException, ClassNotFoundException, NamingException {
		String sql = " UPDATE categorias SET activo = 0 WHERE ID_Categoria = ?";
		
		Connection c = DBUtils.conectaBBDD();
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		c.close();
		return resultado;
	}

}
