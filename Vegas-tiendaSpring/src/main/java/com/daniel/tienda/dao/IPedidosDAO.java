package com.daniel.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.PedidosDTO;

public interface IPedidosDAO {

	public List<PedidosDTO> buscarPedidos(String id, String id_cliente, String fecha, String estado)
			throws SQLException, ClassNotFoundException, NamingException;
}
