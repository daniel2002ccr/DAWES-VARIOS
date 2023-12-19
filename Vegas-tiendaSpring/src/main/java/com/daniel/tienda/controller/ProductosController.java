package com.daniel.tienda.controller;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.negocio.ICategoriaServicio;
import com.daniel.tienda.negocio.IProductoServicio;

@Controller
@RequestMapping("/productos/")
public class ProductosController {
	
	@Autowired
	ICategoriaServicio categoriaServicio;	
	IProductoServicio productoServicio;	
	I

	@GetMapping("listadoproductos")
	public String getListadoProductos() {
		return "listadoProductos";
	}
	
	@PostMapping("listadoproductos")
	public String buscarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
								@RequestParam("descripcion")String descripcion, @RequestParam("precio")String precio,@RequestParam("cantidadStock")String cantidadStock, @RequestParam("categorias")String id_categoria, @RequestParam("proveedores") String id_proveedor, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		precio = (precio == "") ? "0":precio;
		cantidadStock = (cantidadStock == "") ? "0":cantidadStock;
		
		
		List<ProductoDTO> listadoProductos = productoServicio.buscarProducto(id, nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
		List<CategoriaDTO> listaCategorias = categoriaServicio.recuperarComboCategoria();
		model.addAttribute("lista", listadoProductos);
		
		return "listadoCategorias";
		
	}

}