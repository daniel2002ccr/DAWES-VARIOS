package com.daniel.imc.dtos;

import java.io.Serializable;

public class ImcDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Double indice;
	
	public ImcDTO(String nombre, Double indice) {
		super();
		this.nombre = nombre;
		this.indice = indice;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getIndice() {
		return indice;
	}
	
	public void setIndice(Double indice) {
		this.indice = indice;
	}
	
	
}
