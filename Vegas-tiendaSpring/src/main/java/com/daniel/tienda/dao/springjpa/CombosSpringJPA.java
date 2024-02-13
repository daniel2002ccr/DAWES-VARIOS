package com.daniel.tienda.dao.springjpa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.daniel.tienda.dao.ICombosDAO;
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.entities.CategoriaEntity;
import com.daniel.tienda.entities.ClienteEntity;
import com.daniel.tienda.entities.EstadoPedidosEntity;
import com.daniel.tienda.entities.PoblacionEntity;
import com.daniel.tienda.entities.ProductoEntity;
import com.daniel.tienda.entities.ProveedoresEntity;
import com.daniel.tienda.repositories.CategoriaRepository;
import com.daniel.tienda.repositories.ClienteRepository;
import com.daniel.tienda.repositories.EstadosPedidosRepository;
import com.daniel.tienda.repositories.PoblacionRepository;
import com.daniel.tienda.repositories.ProductoRepository;
import com.daniel.tienda.repositories.ProveedoresRepository;

@Component("combospringdatajpa")
public class CombosSpringJPA implements ICombosDAO{
	@Autowired
	private CategoriaRepository categoria;
	@Autowired
	private ProveedoresRepository proveedor;
	@Autowired
	private PoblacionRepository poblacion;
	@Autowired
	private ClienteRepository cliente;
	@Autowired
	private ProductoRepository producto;
	@Autowired
	private EstadosPedidosRepository estado;
	
	private List<CombosDTO> mapeoCategoriaComboDTO(Iterable<CategoriaEntity> listaEntidadesCategoria){
		List<CombosDTO>listaCombos = new ArrayList<>();
		for(CategoriaEntity ce : listaEntidadesCategoria) {
			listaCombos.add(new CombosDTO(ce.getId(), ce.getNombre()));
		}
		return listaCombos;
	}

	
	
	private List<CombosDTO> mapeoProveedorComboDTO(Iterable<ProveedoresEntity> listaEntidadesProveedores){
		List<CombosDTO>listaCombos = new ArrayList<>();
		for(ProveedoresEntity pe : listaEntidadesProveedores) {
			listaCombos.add(new CombosDTO(pe.getIdProveedor(), pe.getNombre()));
		}
		return listaCombos;
	}
	
	private List<CombosDTO> mapeoPoblacionComboDTO(Iterable<PoblacionEntity> listaEntidadesPoblacion){
		List<CombosDTO>listaCombos = new ArrayList<>();
		for(PoblacionEntity pe : listaEntidadesPoblacion) {
			listaCombos.add(new CombosDTO(pe.getId(), pe.getNombre()));
		}
		
		return listaCombos;
	}
	private List<CombosDTO> mapeoClienteComboDTO(Iterable<ClienteEntity> listaEntidadesCliente){
		List<CombosDTO>listaCombos = new ArrayList<>();
		for(ClienteEntity ce : listaEntidadesCliente) {
			listaCombos.add(new CombosDTO(ce.getId(), ce.getNombre()));
		}
		return listaCombos;
	}
	private List<CombosDTO> mapeoProductoComboDTO(Iterable<ProductoEntity> listaEntidadesProducto){
		List<CombosDTO>listaCombos = new ArrayList<>();
		for(ProductoEntity pe : listaEntidadesProducto) {
			listaCombos.add(new CombosDTO(pe.getId(), pe.getNombre()));
		}
		return listaCombos;
	}
	private List<CombosDTO> mapeoEstadoComboDTO(Iterable<EstadoPedidosEntity> listaEntidadesEstado){
		List<CombosDTO>listaCombos = new ArrayList<>();
		for(EstadoPedidosEntity ep : listaEntidadesEstado) {
			listaCombos.add(new CombosDTO(ep.getId(), ep.getNombre()));
		}
		return listaCombos;
	}

	@Override
	public List<CombosDTO> recuperarComboCategoria() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<CategoriaEntity> listaEntidadesCategorias = categoria.findAll();
		return mapeoCategoriaComboDTO(listaEntidadesCategorias);
	}

	@Override
	public List<CombosDTO> recuperarComboProveedores() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<ProveedoresEntity> listaEntidadesProveedores = proveedor.findAll();
		return mapeoProveedorComboDTO(listaEntidadesProveedores);
	}

	@Override
	public List<CombosDTO> recuperarComboPoblacion() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<PoblacionEntity> listaEntidadesPoblacion = poblacion.findAll();
		return mapeoPoblacionComboDTO(listaEntidadesPoblacion);
	}

	@Override
	public List<CombosDTO> recuperarComboCliente() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<ClienteEntity> listaEntidadesCliente = cliente.findAll();
		return mapeoClienteComboDTO(listaEntidadesCliente);
	}

	@Override
	public List<CombosDTO> recuperarComboProducto() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<ProductoEntity> listaEntidadesProducto = producto.findAll();
		return mapeoProductoComboDTO(listaEntidadesProducto);
	}

	@Override
	public List<CombosDTO> recuperarComboEstado() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<EstadoPedidosEntity> listaEntidadesEstado = estado.findAll();
		return mapeoEstadoComboDTO(listaEntidadesEstado);
	}

	
}
