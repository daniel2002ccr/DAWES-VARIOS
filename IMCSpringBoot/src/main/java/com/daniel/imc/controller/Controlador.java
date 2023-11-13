package com.daniel.imc.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.daniel.imc.negocio.IMCNegocioInterface;

public class Controlador {
	@Autowired
	IMCNegocioInterface imc;

	@RequestMapping(value = "/imc")
	public String calculaDescuento(@RequestParam("nombre") String nombre, ModelMap model) throws IOException, ParseException {

		Double indice = imc.obtenerIMC(nombre);
		model.addAttribute("imc", indice);
		model.addAttribute("nombre", nombre);
		return "imcvista";
	}
}
