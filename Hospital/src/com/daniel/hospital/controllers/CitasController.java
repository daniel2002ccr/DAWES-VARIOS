package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.CitasDTO;
import com.daniel.hospital.model.CitasModelo;

public class CitasController {

	public Integer crearCita (String pacienteNombre, String medicoNombre, String fecha, String hora, String estado)  throws ClassNotFoundException, SQLException{
		
		CitasModelo cm = new CitasModelo();
		return cm.crearCita(pacienteNombre, medicoNombre, fecha, hora, estado);
	}

	public Integer actualizarCita (int citaId, String pacienteNombre, String medicoNombre, String fecha, String hora, String estado)  throws ClassNotFoundException, SQLException{
		
		CitasModelo cm = new CitasModelo();
		return cm.actualizaCita(citaId, pacienteNombre, medicoNombre, fecha, hora, estado);
	}
	
	public List<CitasDTO> buscarCita(int citaId, String pacienteNombre, String medicoNombre, String fecha, String hora, String estado) throws ClassNotFoundException, SQLException {
		
		CitasModelo cm = new CitasModelo();
		return cm.buscarCita(citaId, pacienteNombre, medicoNombre, fecha, hora, estado);
	}
		
}
