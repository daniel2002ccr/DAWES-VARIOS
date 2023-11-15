package com.daniel.foreach.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.daniel.foreach.bean.Persona;
import com.daniel.foreach.negocio.INegocio;


@Controller
public class Controlador {
	
	
	@Autowired
	INegocio negocio;
	@RequestMapping(value="/persona")
	public String lista(ModelMap model){
		List<Persona> listaPersonas= negocio.buscarLista();
		model.addAttribute("listaPersonas", listaPersonas);
		return "vista";
		
	}
}
