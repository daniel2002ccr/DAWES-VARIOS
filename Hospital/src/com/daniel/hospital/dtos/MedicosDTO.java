package com.daniel.hospital.dtos;

public class MedicosDTO {

	private int idMedico;
	private String nombre;
	private String apellido;
	private String especialidad;
	private String licencia;
	private String telefono;
	private String correo;
	
	public MedicosDTO(int idMedico, String nombre, String apellido, String especialidad, String licencia,
			String telefono, String correo) {
		super();
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.licencia = licencia;
		this.telefono = telefono;
		this.correo = correo;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "MedicosDTO [idMedico=" + idMedico + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad="
				+ especialidad + ", licencia=" + licencia + ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	
	
}
