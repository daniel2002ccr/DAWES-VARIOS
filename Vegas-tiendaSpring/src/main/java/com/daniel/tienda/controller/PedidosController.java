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
import com.daniel.tienda.dao.IPedidosDAO;
import com.daniel.tienda.dtos.CombosDTO;

import com.daniel.tienda.dtos.PedidosDTO;

import com.daniel.tienda.negocio.ICombosServicio;

@Controller
@RequestMapping("/pedidos/")
public class PedidosController {

	@Autowired
	ICombosServicio combos;
	
	@Autowired
	IPedidosDAO pedidosDAO;
	
	
	@GetMapping("listarpedidos")
	public String getListadoPedidos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();
		

		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosEstado", listadoEstados);
		return "listadoPedidos";
	}
	
	@PostMapping("listarpedidos")
	public String buscarPeticiones(@RequestParam("id") String id, @RequestParam("cliente") String id_cliente,
			@RequestParam("fecha") String fecha, @RequestParam("estado") String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoProductos = combos.recuperarComboProducto();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();
		
		fecha = (fecha == "") ? "1970-01-01" : fecha;
		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosProducto", listadoProductos);
		model.addAttribute("combosEstado", listadoEstados);
		
		List<PedidosDTO> listadoPedidos = pedidosDAO.buscarPedidos(id, id_cliente, fecha, estado);
		
		model.addAttribute("lista" , listadoPedidos);

		return "listadoPedidos";

	}
	
//	@PostMapping("calculaprecio")
//	public @ResponseBody Double calculaPrecio(ModelMap model, @RequestBody ClienteProductoDTO clienteproducto) {
//		System.out.println(clienteproducto.getCliente() + "," + clienteproducto.getProducto());
//		return 3.0;
//		
//	}
//	@PostMapping("dopedido")
//	public ResponseEntity<String> creaPedido(ModelMap model, @RequestBody List<ItemDTO> lista){
//		
//		
//		for (ItemDTO i : lista) {
//			System.out.println(i.getClienteNombre() + " " + i.getProductoNombre());
//		}
//		return ResponseEntity.ok("Pedido realisado con ecsito");
//	}
	
}
