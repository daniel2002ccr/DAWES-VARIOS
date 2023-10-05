package com.daniel.hospital.dtos;

public class EstadoFacturacionDTO {

	private int id;
	private String estado;
	
	
	public EstadoFacturacionDTO(int id, String estado) {
		super();
		this.id = id;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EstadoFacturacionDTO [id=" + id + ", estado=" + estado + "]";
	}
	
	
}
