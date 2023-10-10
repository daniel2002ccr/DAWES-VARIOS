package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.HistorialMedicoDTO;
import com.daniel.hospital.model.HistorialMedicoModelo;

public class HistorialMedicoController {

	public Integer crearHistorial (String pacienteNombre, String medicoNombre, String fecha, String diagnostico, String tratamiento)  throws ClassNotFoundException, SQLException{
		
		HistorialMedicoModelo hmm = new HistorialMedicoModelo();
		return hmm.crearHistorial(pacienteNombre, medicoNombre, fecha, diagnostico, tratamiento);
		
	}
	
	public List <HistorialMedicoDTO> buscarHistorial (int id, String pacienteNombre, String medicoNombre, String fecha, String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException{
		
		HistorialMedicoModelo hmm = new HistorialMedicoModelo();
		return hmm.buscarHistorial(id, pacienteNombre, medicoNombre, fecha, diagnostico, tratamiento);
	}
	
	public Integer actualizarHistorial (int id, String pacienteNombre, String medicoNombre, String fecha, String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException{
		
		HistorialMedicoModelo hmm = new HistorialMedicoModelo();
		return hmm.actualizarHistorial(id, pacienteNombre, medicoNombre, fecha, diagnostico, tratamiento);
	}
		
		
}
