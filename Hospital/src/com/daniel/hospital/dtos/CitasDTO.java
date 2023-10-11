package com.daniel.hospital.dtos;

public class CitasDTO {
	
    private int citaId;
    private String pacienteNombre;
    private String medicoNombre;
    private String fecha;
    private String hora;
    private String estado;

    public CitasDTO(int citaId, String pacienteNombre, String medicoNombre, String fecha, String hora, String estado) {
        this.citaId = citaId;
        this.pacienteNombre = pacienteNombre;
        this.medicoNombre = medicoNombre;
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
		return "CitasDTO [citaId=" + citaId + ", pacienteNombre=" + pacienteNombre + ", medicoNombre=" + medicoNombre
				+ ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + "]";
	}

    
}
