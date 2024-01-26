package com.daniel.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.jdbc.PedidosDAO;
import com.daniel.tienda.dtos.PedidosDTO;
import com.daniel.tienda.negocio.IPedidosServicio;

@Component
public class PedidosServicio implements IPedidosServicio {

	
	@Autowired
	PedidosDAO pedidosDAO;
	@Override
	public List<PedidosDTO> buscarPedidos(String id, String id_cliente, String fecha, String estado)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return pedidosDAO.buscarPedidos(id, id_cliente, fecha, estado);
	}
	@Override
	public Integer actualizarPedidos(String id, String id_cliente, String id_producto, String id_detalle,
			String cantidad, String precio, String estado)
			throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return pedidosDAO.actualizarPedidos(id, id_cliente, id_producto, id_detalle, cantidad, precio, estado);
	}
	

}
