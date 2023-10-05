package com.daniel.hospital.dtos;

public class AlergiaDTO {

	private Integer id;
	private String descripcion;
	
	//constructor, getters y setters

	public AlergiaDTO(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	

	public AlergiaDTO() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
}
