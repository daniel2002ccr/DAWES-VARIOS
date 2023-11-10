package com.daniel.imc.dtos;

import java.io.Serializable;

public class ImcDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Integer altura;
	private Integer peso;
	
	
	public ImcDTO(String nombre, Integer altura, Integer peso) {
		super();
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getAltura() {
		return altura;
	}


	public void setAltura(Integer altura) {
		this.altura = altura;
	}


	public Integer getPeso() {
		return peso;
	}


	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	
	
}
