package com.daniel.hospital.dtos;

public class EstadoCitasDTO {

	private int id;
	private String estado;
	
	
	public EstadoCitasDTO(int id, String estado) {
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
		return "EstadoCitasDTO [id=" + id + ", estado=" + estado + "]";
	}
	
	
}
