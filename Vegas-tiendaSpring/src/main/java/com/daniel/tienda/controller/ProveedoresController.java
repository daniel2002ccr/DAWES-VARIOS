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
import com.daniel.tienda.dtos.ProveedoresDTO;
import com.daniel.tienda.negocio.IProveedoresServicio;

@Controller
@RequestMapping("/proveedores/")
public class ProveedoresController {

	@Autowired
	IProveedoresServicio proveedoresServicio;

	@GetMapping("listadoproveedores")
	public String getListadoProveedores() {
		return "listadoProveedores";
	}

	@PostMapping("listadoproveedores")
	public String buscarProveedor(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ProveedoresDTO> listadoProveedores = proveedoresServicio.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);

		model.addAttribute("lista", listadoProveedores);

		return "listadoProveedores";

	}

	@GetMapping("insertarproveedor")
	public String getInsertarProveedor() {

		return "insertarProveedor";
	}

	@PostMapping("insertarproveedor")
	public String insertarProveedor(String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		Integer resultado = proveedoresServicio.insertarProveedor(nombre, contacto, telefono, correo, direccion,
				activo);
		model.addAttribute("resultado", resultado);

		return "insertarProveedor";

	}

	@GetMapping("formularioactualizarproveedor")
	public String getFormularioActualizarProveedor() {
		return "actualizarProveedor";
	}

	@PostMapping("formularioactualizarproveedor")
	public String getFormulariosActualizarProveedor(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
	@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
	@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
	@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ProveedoresDTO> listadoProveedores = proveedoresServicio.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);
		model.addAttribute("lista", listadoProveedores);

		return "actualizarProveedor";
	}
	
	@PostMapping("actualizarproveedor")
	public String actualizarProveedor(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		activo = (activo != null)? "1": "0";
		
		Integer resultado = proveedoresServicio.actualizarProveedor(id, nombre, contacto, telefono, correo, direccion, activo);
		model.addAttribute("resultado", resultado);
		
		return "actualizarProveedor";
	}
}
