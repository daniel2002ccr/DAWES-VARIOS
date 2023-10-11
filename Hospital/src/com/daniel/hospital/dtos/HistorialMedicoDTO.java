package com.daniel.hospital.dtos;

public class HistorialMedicoDTO {
	    private int id;
	    private String pacienteNombre;
	    private String medicoNombre;
	    private String fecha;
	    private String diagnostico;
	    private String tratamiento;

	    public HistorialMedicoDTO(int id, String pacienteNombre, String medicoNombre, String fecha, String diagnostico, String tratamiento) {
	        this.id = id;
	        this.pacienteNombre = pacienteNombre;
	        this.medicoNombre = medicoNombre;
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
			return "HistorialMedicoDTO [id=" + id + ", pacienteNombre=" + pacienteNombre + ", medicoNombre="
					+ medicoNombre + ", fecha=" + fecha + ", diagnostico=" + diagnostico + ", tratamiento="
					+ tratamiento + "]";
		}
	    
	    
	}
