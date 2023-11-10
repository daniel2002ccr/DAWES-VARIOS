package com.daniel.coches.controlador;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.coches.negocio.ICochesNegocio;

@Controller
public class Controlador {
	@Autowired
	ICochesNegocio coches;

	@RequestMapping(value = "/coches")
	public String calculaDescuento(@RequestParam("nombre") String nombre, ModelMap model) throws IOException, ParseException {

		Integer cantidad = coches.obtenerNumeroCoches(nombre);
		model.addAttribute("cantidad", cantidad);
		model.addAttribute("nombre", nombre);
		return "cochesvista";
	}

}
