package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.MedicosDTO;
import com.daniel.hospital.model.MedicosModelo;

public class MedicosController {
	
	public Integer crearMedico(String nombre, String apellido, String especialidad, String licencia,
			String telefono, String correo) throws ClassNotFoundException, SQLException {
		
		MedicosModelo mm = new MedicosModelo();
		return mm .crearMedico(nombre, apellido, especialidad, licencia, telefono, correo);
	}
	
	public List<MedicosDTO> buscarMedico(int idMedico, String nombre, String apellido, String especialidad,
			String licencia, String telefono, String correo) throws ClassNotFoundException, SQLException {
		
		MedicosModelo mm = new MedicosModelo();
		return mm.buscarMedico(idMedico, nombre, apellido, especialidad, licencia, telefono, correo);
	}
	
	public Integer actualizarHabitacion(int idMedico, String nombre, String apellido, String especialidad,
			String licencia, String telefono, String correo)
			throws SQLException, ClassNotFoundException {
		
		MedicosModelo mm = new MedicosModelo();
		return mm.actualizarMedicos(idMedico, nombre, apellido, especialidad, licencia, telefono, correo);
	}




}
