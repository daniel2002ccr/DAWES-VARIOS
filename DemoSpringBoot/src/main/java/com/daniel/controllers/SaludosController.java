package com.daniel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaludosController {

	@RequestMapping(value="hola")
	public String saludar() {
		return "saludo";
		
	}
 
}
