package com.daniel.tienda.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.daniel.tienda.dtos.ClienteProductoDTO;
import com.daniel.tienda.dtos.ItemDTO;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	@PostMapping("/calculaprecio")
	public @ResponseBody Double calculaPrecio(ModelMap model, @RequestBody ClienteProductoDTO clienteproducto) {
		System.out.println(clienteproducto.getCliente() + "," + clienteproducto.getProducto());
		return 3.0;
		
	}
	@PostMapping("/dopedido")
	public ResponseEntity<String> creaPedido(ModelMap model, @RequestBody List<ItemDTO> lista){
		
		
		for (ItemDTO i : lista) {
			System.out.println(i.getClienteNombre() + " " + i.getProductoNombre());
		}
		return ResponseEntity.ok("Pedido realisado con ecsito");
	}
	
}
