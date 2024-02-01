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
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.negocio.ICategoriaServicio;
import com.daniel.tienda.negocio.ICombosServicio;
import com.daniel.tienda.negocio.IProductoServicio;

@Controller
@RequestMapping("/productos/")
public class ProductosController {
	
	@Autowired
	ICombosServicio combosServicio;	
	
	
	@Autowired
	IProductoServicio productoServicio;	
	

	@GetMapping("listadoproductos")
	public String getListadoProductos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<CombosDTO> listaCategorias = combosServicio.recuperarComboCategoria();
		List <CombosDTO> listaProveedores = combosServicio.recuperarComboProveedores();
		
		model.addAttribute("combosCategoria", listaCategorias);
		model.addAttribute("combosProveedor", listaProveedores);
		
		return "listadoProductos";
	}
	
	@PostMapping("listadoproductos")
	public String buscarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
								@RequestParam("descripcion")String descripcion, @RequestParam("precio")String precio,@RequestParam("cantidadStock")String cantidadStock, @RequestParam("categorias")String id_categoria, @RequestParam("proveedores") String id_proveedor, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		precio = (precio == "") ? "0":precio;
		cantidadStock = (cantidadStock == "") ? "0":cantidadStock;
		
		
		
		List<CombosDTO> listaCategorias = combosServicio.recuperarComboCategoria();
		List <CombosDTO> listaProveedores = combosServicio.recuperarComboProveedores();
		
		model.addAttribute("combosCategoria", listaCategorias);
		model.addAttribute("combosProveedor", listaProveedores);
		
		
		List<ProductoDTO> listaProductos = productoServicio.buscarProducto(id, nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
		model.addAttribute("lista", listaProductos);
		
		return "listadoProductos";
		
	}

	@GetMapping("insertarproducto")
	public String getInsertarProducto(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<CombosDTO> listaCategorias = combosServicio.recuperarComboCategoria();
		List <CombosDTO> listaProveedores = combosServicio.recuperarComboProveedores();
		
		model.addAttribute("combosCategoria", listaCategorias);
		model.addAttribute("combosProveedor", listaProveedores);
		
		return "insertarProducto";
		
	}
	
	@PostMapping("insertarproducto")
	public String insertarProducto(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion")String descripcion, @RequestParam("precio")String precio,@RequestParam("cantidadStock")String cantidadStock, @RequestParam("categorias")String id_categoria, @RequestParam("proveedores") String id_proveedor, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
				
		precio = (precio == "") ? "0":precio;
		cantidadStock = (cantidadStock == "") ? "0":cantidadStock;
		
		Integer resultado = productoServicio.insertarProducto(nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
		model.addAttribute("resultado", resultado);
		
		return "insertarProducto";
		
	}
	@GetMapping("formularioactualizarproducto")
	public String getFormularioActualizarProducto(ModelMap model
			) throws ClassNotFoundException, SQLException, NamingException {
		
		List<CombosDTO> listaCategorias = combosServicio.recuperarComboCategoria();
		List <CombosDTO> listaProveedores = combosServicio.recuperarComboProveedores();
		
		model.addAttribute("combosCategoria", listaCategorias);
		model.addAttribute("combosProveedor", listaProveedores);
		
		return "actualizarProducto";
	}
	
	@PostMapping("formularioactualizarproducto")
	public String getFormulariosActualizarAlumnos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion")String descripcion, @RequestParam("precio")String precio,@RequestParam("cantidadStock")String cantidadStock, @RequestParam("categorias")String id_categoria, @RequestParam("proveedores") String id_proveedor, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		precio = (precio == "") ? "0":precio;
		cantidadStock = (cantidadStock == "") ? "0":cantidadStock;
		
		
		
		List<CombosDTO> listaCategorias = combosServicio.recuperarComboCategoria();
		List <CombosDTO> listaProveedores = combosServicio.recuperarComboProveedores();
		
		model.addAttribute("combosCategoria", listaCategorias);
		model.addAttribute("combosProveedor", listaProveedores);
		
		
		List<ProductoDTO> listaProductos = productoServicio.buscarProducto(id, nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
		model.addAttribute("lista", listaProductos);
		
		return "actualizarProducto";
	}
	
	@PostMapping("actualizarproducto")
	public String actualizarCategoria(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion")String descripcion, @RequestParam("precio")String precio,@RequestParam("cantidadStock")String cantidadStock, @RequestParam("categorias")String id_categoria, @RequestParam("proveedores") String id_proveedor, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<CombosDTO> listaCategorias = combosServicio.recuperarComboCategoria();
		List <CombosDTO> listaProveedores = combosServicio.recuperarComboProveedores();
		
		model.addAttribute("combosCategoria", listaCategorias);
		model.addAttribute("combosProveedor", listaProveedores);
		
		precio = (precio == "") ? "0":precio;
		cantidadStock = (cantidadStock == "") ? "0":cantidadStock;
		
		Integer resultado = productoServicio.actualizarProducto(id, nombre, descripcion, precio, cantidadStock, id_categoria, id_proveedor);
		model.addAttribute("resultado", resultado);
		
		return "actualizarProducto";
	}
}