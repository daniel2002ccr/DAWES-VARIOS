package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.HabitacionDTO;
import com.daniel.hospital.model.HabitacionModelo;

public class HabitacionesController {

	public Integer crearHabitacion (int habId, String tipo, String estado, float costeDia) throws ClassNotFoundException, SQLException{
		
		 HabitacionModelo hm = new HabitacionModelo();
		return hm.crearHabitacion(habId, tipo, estado, costeDia);
		
	}

	public List<HabitacionDTO> buscarHabitacion(int habId, String tipo, String estado, float costeDia) throws ClassNotFoundException, SQLException{
		
		HabitacionModelo hm = new HabitacionModelo();
		return hm.buscarHabitacion(habId, tipo, estado, costeDia);
		
	}
	public Integer actualizarHabitacion(int habId, String tipo, String estado, float costeDia) throws SQLException, ClassNotFoundException{
		
		HabitacionModelo hm = new HabitacionModelo();
		return hm.actualizarHabitacion(habId, tipo, estado, costeDia);
		
	}
	
}
