package com.daniel.tienda.dao.springjpa;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.Query;

import com.daniel.tienda.dao.IProductosDAO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.entities.ProductoEntity;
import com.daniel.tienda.repositories.CategoriaRepository;
import com.daniel.tienda.repositories.ProductoRepository;
import com.daniel.tienda.repositories.ProveedoresRepository;

@Component("ProductoSpringJPA")
public class ProductoSpringJPA implements IProductosDAO{

	@Autowired
	CategoriaRepository categoria;
	
	@Autowired
	ProveedoresRepository proveedores;
	
	@Autowired
	ProductoRepository producto;
	
	@Override
	public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String id_categoria, String id_proveedor)
			throws SQLException, ClassNotFoundException, NamingException {
		
		
		return producto.buscarProducto(id, nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadStock,
			String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		
		
		ProductoEntity pre = new ProductoEntity(nombre, descripcion, Double.parseDouble(precio), Integer.parseInt(cantidadStock), categoria.findById(Integer.parseInt(id_categoria)).get(), proveedores.findById(Integer.parseInt(id_proveedor)).get());
		producto.save(pre);
		return pre.getId();
	}

	@Override
	public Integer actualizarProducto(String id, String nombre, String descripcion, String precio, String cantidadStock,
			String id_categoria, String id_proveedor) throws SQLException, ClassNotFoundException, NamingException {
		
		ProductoEntity pre = new ProductoEntity(Integer.parseInt(id),nombre, descripcion, Double.parseDouble(precio), Integer.parseInt(cantidadStock), categoria.findById(Integer.parseInt(id_categoria)).get(), proveedores.findById(Integer.parseInt(id_proveedor)).get());
		producto.save(pre);
		
		return pre.getId();
	}

}
