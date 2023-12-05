package com.daniel.colegio.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

	@GetMapping("/")
	public String Principal() {
		return "index";
	}
}
