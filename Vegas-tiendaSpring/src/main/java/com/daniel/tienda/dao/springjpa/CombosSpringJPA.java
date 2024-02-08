package com.daniel.tienda.dao.springjpa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.tienda.dao.ICombosDAO;
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.entities.CategoriaEntity;
import com.daniel.tienda.entities.ProveedoresEntity;
import com.daniel.tienda.repositories.CategoriaRepository;
import com.daniel.tienda.repositories.ProveedoresRepository;

@Service
public class CombosSpringJPA implements ICombosDAO{
	@Autowired
	private CategoriaRepository categoria;
	@Autowired
	private ProveedoresRepository proveedor;
	
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

	@Override
	public List<CombosDTO> recuperarComboCategoria() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<CategoriaEntity> listaEntidadesCategorias = categoria.findAll();
		return mapeoCategoriaComboDTO(listaEntidadesCategorias);
	}

	@Override
	public List<CombosDTO> recuperarComboProovedor() throws SQLException, ClassNotFoundException, NamingException {
		Iterable<ProveedoresEntity> listaEntidadesProveedores = proveedor.findAll();
		return mapeoProveedorComboDTO(listaEntidadesProveedores);
	}

	@Override
	public List<CombosDTO> recuperarComboPoblacion() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CombosDTO> recuperarComboCliente() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CombosDTO> recuperarComboProducto() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CombosDTO> recuperarComboEstado() throws SQLException, ClassNotFoundException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
