package com.daniel.hospital.dtos;

public class RecetasMedicasDTO {

	private int id;
	private String pacienteNombre;
	private String medicoNombre;
	private String medicamentoNombre;
	private String fecha;
	private int cantidadPrescrita;
	
	
	
	public RecetasMedicasDTO(int id, String pacienteNombre, String medicoNombre, String medicamentoNombre, String fecha,
			int cantidadPrescrita) {
		super();
		this.id = id;
		this.pacienteNombre = pacienteNombre;
		this.medicoNombre = medicoNombre;
		this.medicamentoNombre = medicamentoNombre;
		this.fecha = fecha;
		this.cantidadPrescrita = cantidadPrescrita;
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



	public String getMedicoNombre() {
		return medicoNombre;
	}



	public void setMedicoNombre(String medicoNombre) {
		this.medicoNombre = medicoNombre;
	}



	public String getMedicamentoNombre() {
		return medicamentoNombre;
	}



	public void setMedicamentoNombre(String medicamentoNombre) {
		this.medicamentoNombre = medicamentoNombre;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public int getCantidadPrescrita() {
		return cantidadPrescrita;
	}



	public void setCantidadPrescrita(int cantidadPrescrita) {
		this.cantidadPrescrita = cantidadPrescrita;
	}



	@Override
	public String toString() {
		return "RecetasMedicasDTO [id=" + id + ", pacienteNombre=" + pacienteNombre + ", medicoNombre=" + medicoNombre
				+ ", medicamentoNombre=" + medicamentoNombre + ", fecha=" + fecha + ", cantidadPrescrita="
				+ cantidadPrescrita + "]";
	}
	
	
	
}
