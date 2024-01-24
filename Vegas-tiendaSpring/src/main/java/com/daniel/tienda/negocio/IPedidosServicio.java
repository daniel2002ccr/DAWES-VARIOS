package com.daniel.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.daniel.tienda.dtos.PedidosDTO;

public interface IPedidosServicio {

	public List<PedidosDTO> buscarPedidos(String id, String id_cliente, String fecha, String estado)
			throws SQLException, ClassNotFoundException, NamingException;
}
