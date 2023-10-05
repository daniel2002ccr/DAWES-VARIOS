package com.daniel.hospital.dtos;

public class PacientesDTO {

	private int idPaciente;
	private String nombre;
	private String apellido;
	private String fechaNac;
	private String dni;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private int idAlergia;
	private String historial;
	
	
	public PacientesDTO(int idPaciente, String nombre, String apellido, String fechaNac, String dni, String direccion,
			String telefono, String correoElectronico, int idAlergia, String historial) {
		super();
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.idAlergia = idAlergia;
		this.historial = historial;
	}


	public int getIdPaciente() {
		return idPaciente;
	}


	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
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


	public String getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public int getIdAlergia() {
		return idAlergia;
	}


	public void setIdAlergia(int idAlergia) {
		this.idAlergia = idAlergia;
	}


	public String getHistorial() {
		return historial;
	}


	public void setHistorial(String historial) {
		this.historial = historial;
	}


	@Override
	public String toString() {
		return "PacientesDTO [idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNac=" + fechaNac + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", correoElectronico=" + correoElectronico + ", idAlergia=" + idAlergia + ", historial=" + historial
				+ "]";
	}
	
	
}
