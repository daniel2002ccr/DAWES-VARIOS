package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.PacientesDTO;
import com.daniel.hospital.model.PacientesModelo;

public class PacientesController {

	public List<PacientesDTO> buscarPacientes(int idPaciente, String nombre, String apellido, String fechaNac, String dni,
			String direccion, String telefono, String correoElectronico, String alergia, String historial) throws ClassNotFoundException, SQLException{
		
		PacientesModelo pm = new PacientesModelo();
		return pm.buscarPaciente(idPaciente, nombre, apellido, fechaNac, dni, direccion, telefono, correoElectronico, alergia, historial);
	}
	
	public Integer creaPaciente(int idPaciente, String nombre, String apellido, String fechaNac, String dni,
			String direccion, String telefono, String correoElectronico, String alergia, String historial)
			throws ClassNotFoundException, SQLException {
		
		PacientesModelo pm = new PacientesModelo();
		return pm.creaPaciente(idPaciente, nombre, apellido, fechaNac, dni, direccion, telefono, correoElectronico, alergia, historial);
	}
	public Integer actualizaPaciente(int idPaciente, String nombre, String apellido, String fechaNac, String dni,
	        String direccion, String telefono, String correoElectronico, String alergia, String historial)
	        throws SQLException, ClassNotFoundException {
		
		PacientesModelo pm = new PacientesModelo();
		return pm.actualizaPaciente(idPaciente, nombre, apellido, fechaNac, dni, direccion, telefono, correoElectronico, alergia, historial);
	
	}
}
