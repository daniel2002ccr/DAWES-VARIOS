package com.daniel.coches.dtos;

import java.io.Serializable;

public class CochesDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Integer cantidad;
	
	
	public CochesDTO(String nombre, Integer cantidad) {
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


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
