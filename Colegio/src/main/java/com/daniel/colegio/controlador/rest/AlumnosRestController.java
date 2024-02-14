package com.daniel.colegio.controlador.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.colegio.entities.AlumnoEntity;
import com.daniel.colegio.repositories.AlumnosRepository;

@RestController
@RequestMapping("/v1")
public class AlumnosRestController {

	@Autowired
	private AlumnosRepository alumnosRepository;
	
	
	@PostMapping("/alumnos")
	public ResponseEntity insertarAlumno(@RequestBody AlumnoEntity alumno){
		
		alumnosRepository.save(alumno);
		
		return new ResponseEntity<>("Alumno insertado con éxito", HttpStatus.OK);
	}
	@PutMapping("/alumnos")
	public ResponseEntity actualizarAlumno(@RequestBody AlumnoEntity alumno){
		
		alumnosRepository.save(alumno);
		
		return new ResponseEntity<>("Alumno aktualisado con éxito", HttpStatus.OK);
	}
	
}
