package com.daniel.tienda.controller;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daniel.tienda.dao.ICombosDAO;
import com.daniel.tienda.dao.IPedidosDAO;
import com.daniel.tienda.dtos.ClienteProductoDTO;
import com.daniel.tienda.dtos.CombosDTO;

import com.daniel.tienda.dtos.PedidosDTO;



@Controller
@RequestMapping("/pedidos/")
public class PedidosController {

	@Autowired
	@Qualifier("combospringdatajpa")
	ICombosDAO combos;

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
	public String buscarPedidos(@RequestParam("id") String id, @RequestParam("cliente") String id_cliente,
			@RequestParam("fecha") String fecha, @RequestParam("estado") String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		fecha = (fecha == "") ? "1970-01-01" : fecha;
		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoProductos = combos.recuperarComboProducto();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();

		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosProducto", listadoProductos);
		model.addAttribute("combosEstado", listadoEstados);

		List<PedidosDTO> listadoPedidos = pedidosDAO.buscarPedidos(id, id_cliente, fecha, estado);

		model.addAttribute("lista", listadoPedidos);

		return "listadoPedidos";

	}

	@GetMapping("formularioactualizarpedidos")
	public String getFormularioActualizarPedidos(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();

		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosEstado", listadoEstados);
		return "actualizarPedidos";
	}

	@PostMapping("formularioactualizarpedidos")
	public String FormularioActualizarPedidos(@RequestParam("id") String id, @RequestParam("cliente") String id_cliente,
			@RequestParam("fecha") String fecha, @RequestParam("estado") String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		fecha = (fecha == "") ? "1970-01-01" : fecha;
		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoProductos = combos.recuperarComboProducto();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();

		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosProducto", listadoProductos);
		model.addAttribute("combosEstado", listadoEstados);

		List<PedidosDTO> listadoPedidos = pedidosDAO.buscarPedidos(id, id_cliente, fecha, estado);

		model.addAttribute("lista", listadoPedidos);
		return "actualizarPedidos";
	}
	
	
	@PostMapping("actualizarpedidos")
	public String ActualizarPeticiones(@RequestParam("id") String id, @RequestParam("cliente") String id_cliente, @RequestParam("producto") String id_producto, @RequestParam("id_detalle") String id_detalle, @RequestParam("cantidad") String cantidad, @RequestParam("precio") String precio,
			String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoProductos = combos.recuperarComboProducto();
		List<CombosDTO> listadoEstados = combos.recuperarComboEstado();
		

		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosProducto", listadoProductos);
		model.addAttribute("combosEstado", listadoEstados);
		
		
		Integer resultado = pedidosDAO.actualizarPedidos(id, id_cliente, id_producto, id_detalle, cantidad, precio, estado);
		model.addAttribute("resultado" , resultado);

		return "actualizarPedidos";
	}

	@GetMapping("insertarpedido")
	public String getInsertarPedidos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listadoClientes = combos.recuperarComboCliente();
		List<CombosDTO> listadoProductos = combos.recuperarComboProducto();
		model.addAttribute("combosCliente", listadoClientes);
		model.addAttribute("combosProducto", listadoProductos);
		return "insertarPedido";
	}
	
	@PostMapping("calculaprecio")
	public @ResponseBody Double calculaPrecio(ModelMap model, @RequestBody ClienteProductoDTO clienteproducto) throws ClassNotFoundException, SQLException, NamingException {

		Double precioBase = pedidosDAO.obtenerPrecio(clienteproducto.getCliente());
		Integer descuento = pedidosDAO.calcularDescuento(clienteproducto.getCliente());
		
		
		
		return precioBase * descuento / 100;
		
	}
//	@PostMapping("dopedido")
//	public ResponseEntity<String> creaPedido(ModelMap model, @RequestBody List<ItemDTO> lista){
//		
//		
//		for (ItemDTO i : lista) {
//			System.out.println(i.getClienteNombre() + " " + i.getProductoNombre());
//		}
//		return ResponseEntity.ok("Pedido realizado con éxito");
//	}

}
