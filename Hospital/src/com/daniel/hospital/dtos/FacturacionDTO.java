package com.daniel.hospital.dtos;

public class FacturacionDTO {

	private int id;
	private String pacienteNombre;
	private String fecha;
	private float monto;
	private String estado;
	
	
	public FacturacionDTO(int id, String pacienteNombre, String fecha, float monto, String estado) {
		super();
		this.id = id;
		this.pacienteNombre = pacienteNombre;
		this.fecha = fecha;
		this.monto = monto;
		this.estado = estado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPacienteNombre() {
		return pacienteNombre;
	}


	public void setPacienteNombre(String pacienteNombre) {
		this.pacienteNombre = pacienteNombre;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public float getMonto() {
		return monto;
	}


	public void setMonto(float monto) {
		this.monto = monto;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "FacturacionDTO [id=" + id + ", pacienteNombre=" + pacienteNombre + ", fecha=" + fecha + ", monto="
				+ monto + ", estado=" + estado + "]";
	}
	
	

}
