package com.daniel.foreachapp.bean;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Integer saldoCuenta;
	
	
	public Persona(String nombre, Integer saldoCuenta) {
		super();
		this.nombre = nombre;
		this.saldoCuenta = saldoCuenta;
	}


	public Persona() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getSaldoCuenta() {
		return saldoCuenta;
	}


	public void setSaldoCuenta(Integer saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}
	
	
	
}
