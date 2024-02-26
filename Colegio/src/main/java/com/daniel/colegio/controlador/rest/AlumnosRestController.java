package com.daniel.colegio.controlador.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.entities.AlumnoEntity;
import com.daniel.colegio.repositories.AlumnosRepository;

@RestController
@RequestMapping("/v1")
public class AlumnosRestController {

	@Autowired
	private AlumnosRepository alumnosRepository;

	@PostMapping("/alumnos")
	public ResponseEntity insertarAlumno(@RequestBody AlumnoEntity alumno) {

		alumnosRepository.save(alumno);

		return new ResponseEntity<>("Alumno insertado con éxito", HttpStatus.OK);
	}

	@PutMapping("/alumnos")
	public ResponseEntity actualizarAlumno(@RequestBody AlumnoEntity alumno) {

		alumnosRepository.save(alumno);

		return new ResponseEntity<>("Alumno aktualisado con éxito", HttpStatus.OK);
	}

	@GetMapping(value = "/alumnos/{id}")
	public AlumnoEntity obtenerAlumnoPorID(@PathVariable("id") Integer id) {
		return alumnosRepository.findById(id).get();
	}

	@DeleteMapping("/alumnos")
	public ResponseEntity borrarAlumno(@PathVariable("id")Integer id){
		
		AlumnoEntity a = alumnosRepository.findById(id).get();
		
		a.setActivo(0);
		alumnosRepository.save(a);
		return new ResponseEntity<>("Alusno bolado con excitamiento", HttpStatus.OK);
	}
}
