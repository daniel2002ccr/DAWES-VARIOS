package com.daniel.tienda.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.tienda.dao.IClientesDAO;
import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.negocio.IClientesServicio;
import com.daniel.tienda.negocio.ICombosServicio;

@Controller
@RequestMapping("/clientes/")
public class ClientesController {

	@Autowired
	ICombosServicio combosServicio;

	@Autowired
	IClientesServicio clientesDAO;

	@GetMapping("listadoclientes")
	public String getListadoProveedores(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("comboPoblacion", listadoPoblacion);

		return "listadoClientes";
	}

	@PostMapping("listadoclientes")
	public String buscarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblacion") String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("comboPoblacion", listadoPoblacion);
		List<ClientesDTO> listadoClientes = clientesDAO.buscarClientes(id, nombre, correo, poblacion, activo);

		model.addAttribute("lista", listadoClientes);

		return "listadoClientes";

	}

	@GetMapping("insertarcliente")
	public String getInsertarProveedor(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);

		return "insertarCliente";
	}

	@PostMapping("insertarcliente")
	public String insertarCliente(@RequestParam("nombre") String nombre, @RequestParam("correo") String correo,
			@RequestParam("poblacion") String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);
		Integer resultado = clientesDAO.insertarCliente(nombre, correo, poblacion, activo);
		model.addAttribute("resultado", resultado);

		return "insertarCliente";

	}

	@GetMapping("formularioactualizarcliente")
	public String getFormularioActualizarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);

		return "actualizarCliente";
	}

	@PostMapping("formularioactualizarcliente")
	public String FormularioActualizarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblacion") String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);
		List<ClientesDTO> listadoClientes = clientesDAO.buscarClientes(id, nombre, correo, poblacion, activo);

		model.addAttribute("lista", listadoClientes);

		return "actualizarCliente";

	}

	@PostMapping("actualizarcliente")
	public String ActualizarCliente(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblacion") String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);
		Integer resultado = clientesDAO.actualizarCliente(id, nombre, correo, poblacion, activo);
		model.addAttribute("resultado", resultado);

		return "actualizarCliente";

	}

	@GetMapping("formularioborrarcliente")
	public String getFormularioBorrarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);

		return "borrarCliente";
	}

	@PostMapping("formularioborrarcliente")
	public String getFormulariosBorrarCliente(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblacion") String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);

		List<ClientesDTO> listaClientes = clientesDAO.buscarClientes(id, nombre, correo, poblacion, activo);
		model.addAttribute("lista", listaClientes);

		return "borrarCliente";
	}

	@PostMapping("borrarcliente")
	public String borrarAlumno(@RequestParam("id") String id, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<CombosDTO> listadoPoblacion = combosServicio.recuperarComboPoblacion();

		model.addAttribute("combosPoblacion", listadoPoblacion);
		Integer resultado = clientesDAO.borrarCliente(id);
		model.addAttribute("resultado", resultado);
		return "borrarCliente";
	}
}
