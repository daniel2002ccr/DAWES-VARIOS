package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dtos.PersonaDTO;

@Controller
public class ObtenerPersonasControllers {
	@RequestMapping(value="/obtenPersona")
	public String daPersona(ModelMap model) {
		
		PersonaDTO p = new PersonaDTO(33, "Fernando Alonso");
		model.addAttribute("persona", p);
		return "hola";
		
	}
	
}
