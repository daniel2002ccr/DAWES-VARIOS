package com.daniel.hospital.dtos;

public class CitasDTO {

	private int citaId;
	private int pacienteId;
	private int medicoId;
	private String fecha;
	private String hora;
	private String estado;
	
	
	public CitasDTO(int citaId, int pacienteId, int medicoId, String fecha, String hora, String estado) {
		super();
		this.citaId = citaId;
		this.pacienteId = pacienteId;
		this.medicoId = medicoId;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
	}


	public int getCitaId() {
		return citaId;
	}


	public void setCitaId(int citaId) {
		this.citaId = citaId;
	}


	public int getPacienteId() {
		return pacienteId;
	}


	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}


	public int getMedicoId() {
		return medicoId;
	}


	public void setMedicoId(int medicoId) {
		this.medicoId = medicoId;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "CitasDTO [citaId=" + citaId + ", pacienteId=" + pacienteId + ", medicoId=" + medicoId + ", fecha="
				+ fecha + ", hora=" + hora + ", estado=" + estado + "]";
	}
	
	
}
