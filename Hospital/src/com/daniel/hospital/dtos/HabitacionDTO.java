package com.daniel.hospital.dtos;

public class HabitacionDTO {

	private int habId;
	private String tipo;
	private String estado;
	private float costeDia;
	
	public HabitacionDTO(int habId, String tipo, String estado, float costeDia) {
		super();
		this.habId = habId;
		this.tipo = tipo;
		this.estado = estado;
		this.costeDia = costeDia;
	}

	public int getHabId() {
		return habId;
	}

	public void setHabId(int habId) {
		this.habId = habId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getCosteDia() {
		return costeDia;
	}

	public void setCosteDia(float costeDia) {
		this.costeDia = costeDia;
	}

	@Override
	public String toString() {
		return "HabitacionDTO [habId=" + habId + ", tipo=" + tipo + ", estado=" + estado + ", costeDia=" + costeDia
				+ "]";
	}
	
	
}
