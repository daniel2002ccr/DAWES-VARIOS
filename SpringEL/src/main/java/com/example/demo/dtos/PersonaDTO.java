package com.example.demo.dtos;



import java.io.Serializable;

public class PersonaDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Integer edad;
	private String nombre;
	
	public PersonaDTO(Integer edad, String nombre) {
		super();
		this.edad = edad;
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}

