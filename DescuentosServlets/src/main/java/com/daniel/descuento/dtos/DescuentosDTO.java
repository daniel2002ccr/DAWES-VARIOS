package com.daniel.descuento.dtos;

import java.io.Serializable;

public class DescuentosDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombre;
	private Integer descuento;
	
	
	public DescuentosDTO(String nombre, Integer descuento) {
		super();
		this.nombre = nombre;
		this.descuento = descuento;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getDescuento() {
		return descuento;
	}
	
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
	
}
