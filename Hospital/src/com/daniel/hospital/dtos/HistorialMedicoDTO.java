package com.daniel.hospital.dtos;

public class HistorialMedicoDTO {

	private int id;
	private int pacienteId;
	private int medicoId;
	private String fecha;
	private String diagnostico;
	private String tratamiento;
	
	
	public HistorialMedicoDTO(int id, int pacienteId, int medicoId, String fecha, String diagnostico,
			String tratamiento) {
		super();
		this.id = id;
		this.pacienteId = pacienteId;
		this.medicoId = medicoId;
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public String getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}


	@Override
	public String toString() {
		return "HistorialMedicoDTO [id=" + id + ", pacienteId=" + pacienteId + ", medicoId=" + medicoId + ", fecha="
				+ fecha + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + "]";
	}
	
	
}
