package com.daniel.tienda.dtos;

public class ClientesDTO {

	private Integer id;
	private String nombre;
	private String correo;
	private String poblacion;
	private Integer id_poblacion;
	private Integer activo;

	public ClientesDTO(Integer id, String nombre, String correo, String poblacion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.poblacion = poblacion;
		this.activo = activo;
	}
	

	public ClientesDTO(Integer id, String nombre, String correo, String poblacion, Integer id_poblacion,
			Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.poblacion = poblacion;
		this.id_poblacion = id_poblacion;
		this.activo = activo;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}


	public Integer getId_poblacion() {
		return id_poblacion;
	}


	public void setId_poblacion(Integer id_poblacion) {
		this.id_poblacion = id_poblacion;
	}

}
