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

import com.daniel.tienda.dao.IPeticionesDAO;
import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.dtos.CombosDTO;
import com.daniel.tienda.dtos.PeticionesDTO;
import com.daniel.tienda.negocio.ICombosServicio;

@Controller
@RequestMapping("/peticiones/")
public class PeticionesController {

	@Autowired
	ICombosServicio combos;
	
	@Autowired
	IPeticionesDAO peticionesDAO;
	
	@GetMapping("listadopeticiones")
	public String getListadoPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoProductos = combos.recuperarComboProducto();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();
		

		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosProducto", listadoClientes);
		model.addAttribute("combosEstado", listadoEstados);
		return "listadoPeticiones";
	}
	
	@PostMapping("listadopeticiones")
	public String buscarPeticiones(@RequestParam("id") String id, @RequestParam("cliente") String id_cliente,
			@RequestParam("producto") String id_producto, @RequestParam("cantidad") String cantidad,
			@RequestParam("estado") String estado, @RequestParam("fecha") String fecha, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoProductos = combos.recuperarComboProducto();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();
		

		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosProducto", listadoProductos);
		model.addAttribute("combosEstado", listadoEstados);
		
		List<PeticionesDTO> listadoPeticiones = peticionesDAO.buscarPeticiones(id, id_cliente, id_producto, fecha, cantidad, estado);
		
		model.addAttribute("lista" , listadoPeticiones);

		return "listadoPeticiones";

	}
}
