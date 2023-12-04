package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.RecetasMedicasDTO;
import com.daniel.hospital.model.RecetasMedicasModelo;

public class RecetasMedicasController {

	public Integer crearReceta(String pacienteNombre, String medicoNombre, String nombreMedicamento, String fecha,
			int cantidad) throws ClassNotFoundException, SQLException {

		RecetasMedicasModelo rmm = new RecetasMedicasModelo();
		return rmm.crearReceta(pacienteNombre, medicoNombre, nombreMedicamento, fecha, cantidad);
	}

	public List<RecetasMedicasDTO> buscarReceta(int id, String pacienteNombre, String medicoNombre,
			String nombreMedicamento, String fecha, int cantidad) throws ClassNotFoundException, SQLException {

		RecetasMedicasModelo rmm = new RecetasMedicasModelo();
		return rmm.buscarReceta(id, pacienteNombre, medicoNombre, nombreMedicamento, fecha, cantidad);
	}

	public Integer actualizaRecetaMedica(int id, String pacienteNombre, String medicoNombre, String nombreMedicamento,
			String fecha, int cantidad) throws ClassNotFoundException, SQLException {

		RecetasMedicasModelo rmm = new RecetasMedicasModelo();
		return rmm.actualizaRecetaMedica(id, pacienteNombre, medicoNombre, nombreMedicamento, fecha, cantidad);
	}

}
