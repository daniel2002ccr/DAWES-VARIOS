package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.AdmisionesDTO;
import com.daniel.hospital.model.AdmisionesModelo;

public class AdmisionesController {

	public Integer creaAdmision(String nombrePaciente, String tipoHabitacion, String fechaEntrada, String fechaSalida,
			String motivo) throws ClassNotFoundException, SQLException {
		
		AdmisionesModelo am = new AdmisionesModelo();
		return am.crearAdmision(nombrePaciente, tipoHabitacion, fechaEntrada, fechaSalida, motivo);
		
	}
	public Integer actualizaAdmision(int id, String nombrePaciente, String tipoHabitacion, String fechaEntrada, String fechaSalida,
			String motivo) throws ClassNotFoundException, SQLException {
		
		AdmisionesModelo am = new AdmisionesModelo();
		return am.actualizaAdmision(id, nombrePaciente, tipoHabitacion, fechaEntrada, fechaSalida, motivo);
	}
	public List<AdmisionesDTO> buscarAdmision(int id, String pacienteNombre, String tipoHabitacion, String fechaEntrada, String fechaSalida, String motivo) throws ClassNotFoundException, SQLException {
		
		AdmisionesModelo am = new AdmisionesModelo();
		return am.buscarAdmision(id, pacienteNombre, tipoHabitacion, fechaEntrada, fechaSalida, motivo);
	}

}
