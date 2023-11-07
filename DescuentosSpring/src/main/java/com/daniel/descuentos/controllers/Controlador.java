package com.daniel.descuentos.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.descuento.negocio.IDescuentos;

@Controller
public class Controlador {
	@Autowired
	IDescuentos descuento;
	
	@RequestMapping(value="/calculadescuento")
	public String calculaDescuento(@RequestParam("nombre")String nombre, ModelMap model) throws IOException {
		
		Integer cantidad = descuento.calculaDescuento(nombre);
		model.addAttribute("descuento", cantidad);
		return "descuentovista";
	}
}
