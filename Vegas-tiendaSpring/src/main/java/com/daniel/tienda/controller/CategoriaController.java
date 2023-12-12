package com.daniel.tienda.controller;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.negocio.ICategoriaServicio;

@Controller
@RequestMapping("/categoria/")
public class CategoriaController {

	
	@Autowired
	ICategoriaServicio categoriaServicio;
	
	@GetMapping("listadocategorias")
	public String getListadoCategoria() {
		return "listadoCategorias";
	}
	
	@PostMapping("listadocategorias")
	public String buscarAlumnos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
								@RequestParam("descripcion")String descripcion, @RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		activo = (activo != null)? "1": "0";
		
		
		List<CategoriaDTO> listadoCategorias = categoriaServicio.buscarCategoria(id, nombre, descripcion, activo);
		
		model.addAttribute("lista", listadoCategorias);
		
		return "listadoCategorias";
		
	}
	
	@GetMapping("insertarcategoria")
	public String getInsertarCategoria() {
		return "insertarCategoria";
	}
	
	@PostMapping("insertarcategoria")
	public String insertarAlumno(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion")String descripcion, @RequestParam(value="activo", required = false)String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		
		
		activo = (activo != null)? "1": "0";
		
		Integer resultado = categoriaServicio.insertarCategoria(nombre, descripcion, activo);
		model.addAttribute("resultado", resultado);
		
		
		
		
		return "insertarCategoria";
	}
}
