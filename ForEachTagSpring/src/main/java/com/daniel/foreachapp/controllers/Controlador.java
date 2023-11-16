package com.daniel.foreachapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniel.foreachapp.bean.Persona;

@Controller
public class Controlador {

	@RequestMapping(value = "/persona")
	public String lista(ModelMap model) {
		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(new Persona("Pepe", 2000));
		listaPersonas.add(new Persona ("kike", 10000));
		listaPersonas.add(new Persona ("Luis", 5000));
		listaPersonas.add(new Persona ("Maria", 3000));
		
		model.addAttribute("listaPersonas",listaPersonas);
		
		return "vista";
	}
}
