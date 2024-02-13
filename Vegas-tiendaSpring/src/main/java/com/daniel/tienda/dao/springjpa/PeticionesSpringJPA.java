package com.daniel.tienda.dao.springjpa;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IPeticionesDAO;
import com.daniel.tienda.dtos.PeticionesDTO;
import com.daniel.tienda.entities.EstadoPedidosEntity;
import com.daniel.tienda.entities.PeticionesEntity;
import com.daniel.tienda.repositories.ClienteRepository;
import com.daniel.tienda.repositories.EstadosPedidosRepository;
import com.daniel.tienda.repositories.PeticionesRepository;
import com.daniel.tienda.repositories.ProductoRepository;

@Component("peticionesSpringJPA")
public class PeticionesSpringJPA implements IPeticionesDAO{

	@Autowired
	ClienteRepository cliente;
	@Autowired
	ProductoRepository producto;
	@Autowired
	EstadosPedidosRepository estados;
	@Autowired
	PeticionesRepository peticion;
	
	@Override
	public List<PeticionesDTO> buscarPeticiones(String id, String id_cliente, String id_producto, String fecha,
			String cantidad, String estado) throws SQLException, ClassNotFoundException, NamingException {

		return peticion.buscarPeticion(id, id_cliente, id_producto, fecha, cantidad, estado);
	}

	@Override
	public Integer insertarPeticion(String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException {

		PeticionesEntity pe = new PeticionesEntity(cliente.findById(Integer.parseInt(id_cliente)).get(), producto.findById(Integer.parseInt(id_producto)).get(), Integer.parseInt(cantidad), estados.findById(Integer.parseInt(estado)).get());
		String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		pe.setFecha(fecha);
		peticion.save(pe);
		return pe.getId();
	}

	@Override
	public Integer actualizarPeticion(String id, String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException {
		
		PeticionesEntity pe = new PeticionesEntity(Integer.parseInt(id),cliente.findById(Integer.parseInt(id_cliente)).get(), producto.findById(Integer.parseInt(id_producto)).get(), Integer.parseInt(cantidad), estados.findById(Integer.parseInt(estado)).get());
		String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		pe.setFecha(fecha);
		peticion.save(pe);
		return pe.getId();
	}

	@Override
	public Integer borrarPeticion(String id) throws SQLException, ClassNotFoundException, NamingException {
		
		PeticionesEntity pe  = peticion.findById(Integer.parseInt(id)).get();
		EstadoPedidosEntity ep = estados.findById(5).get();
		pe.setEstados(ep);
		peticion.save(pe);
		return pe.getId();
	}

}
