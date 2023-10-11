package com.daniel.hospital.dtos;

public class AdmisionesDTO {

	private int id;
	private String nombrePaciente;
	private String tipoHabitacion;
	private String fechaEntrada;
	private String fechaSalida;
	private String motivo;

	public AdmisionesDTO(int id, String nombrePaciente, String tipoHabitacion, String fechaEntrada, String fechaSalida,
			String motivo) {
		super();
		this.id = id;
		this.nombrePaciente = nombrePaciente;
		this.tipoHabitacion = tipoHabitacion;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.motivo = motivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String toString() {
		return "AdmisionesDTO [id=" + id + ", nombrePaciente=" + nombrePaciente + ", tipoHabitacion=" + tipoHabitacion
				+ ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", motivo=" + motivo + "]";
	}
}
