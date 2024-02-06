package com.daniel.colegio.controlador;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.colegio.dao.ICombosDAO;
import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.dtos.ComboDTO;
import com.daniel.colegio.negocio.IAlumnosServicio;

@Controller
@RequestMapping("/alumnos/")
public class AlumnosController {

	@Autowired
	IAlumnosServicio alumnosServicio;
	@Autowired
	@Qualifier("combospringdatajpa")
	ICombosDAO combosDAO;

	@GetMapping("listaralumnos")
	public String getListadoAlumnos() {
		return "listadoAlumnos";
	}

	@PostMapping("listaralumnos")
	public String buscarAlumnos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		List<AlumnoDTO> listaAlumnos = alumnosServicio.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);

		model.addAttribute("lista", listaAlumnos);
		return "listadoAlumnos";
	}

	@GetMapping("insertaralumnos")
	public String getInsertarAlumnos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();
		model.addAttribute("combosMunicipios", listaMunicipios);
		return "insertarAlumnos";
	}

	@PostMapping("insertaralumnos")
	public String insertarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo,
			@RequestParam("municipios") String municipios, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		Integer resultado = alumnosServicio.insertarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
		model.addAttribute("resultado", resultado);
		model.addAttribute("combosMunicipios", listaMunicipios);
		return "insertarAlumnos";
	}

	@GetMapping("formularioactualizaralumnos")
	public String getActualizarAlumnos() {
		return "actualizarAlumnos";
	}

	@PostMapping("formularioactualizaralumnos")
	public String getActualizarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();
		model.addAttribute("combosMunicipios", listaMunicipios);

		List<AlumnoDTO> listaAlumnos = alumnosServicio.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
		model.addAttribute("lista", listaAlumnos);
		return "actualizarAlumnos";

	}

	@PostMapping("actualizaralumnos")
	public String actualizarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo,
			@RequestParam("municipios") String municipios, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		
		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";
		alumnosServicio.actualizarAlumno(id, nombre, apellido, activo, famNumerosa, municipios);
		return "actualizarAlumnos";
	}
	
	@GetMapping("formularioborraralumnos")
	public String getBorrarAlumno(){
		return "borrarAlumnos";
}
	
	@PostMapping("formularioborraralumnos")
	public String getFormularioBorrarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		
		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		List<ComboDTO> listaMunicipios = combosDAO.recuperaCombosMunicipio();
		model.addAttribute("combosMunicipios", listaMunicipios);

		List<AlumnoDTO> listaAlumnos = alumnosServicio.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
		model.addAttribute("lista", listaAlumnos);
		return "borrarAlumnos";
	}
	
	@PostMapping("borraralumnos")
	public String borrarAlumno(@RequestParam("id") String id) throws ClassNotFoundException, SQLException, NamingException {
		
		alumnosServicio.borrarAlumno(id);
		return "borrarAlumnos";
	}
}
