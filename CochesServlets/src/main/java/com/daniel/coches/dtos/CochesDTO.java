package com.daniel.coches.dtos;

import java.io.Serializable;

public class CochesDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String cantidad;
	
	
	public CochesDTO(String nombre, String cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
