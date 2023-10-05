package com.daniel.hospital.dtos;

public class DepartamentosDTO {

	private int idDepartamento;
	private String nombre;
	private String descripcion;
	private int activo;
	
	
	public DepartamentosDTO(int idDepartamento, String nombre, String descripcion, int activo) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}


	public int getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getActivo() {
		return activo;
	}


	public void setActivo(int activo) {
		this.activo = activo;
	}


	@Override
	public String toString() {
		return "DepartamentosDTO [idDepartamento=" + idDepartamento + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", activo=" + activo + "]";
	}
	
	
}
