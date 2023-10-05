package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.EstadoCitasDTO;
import com.daniel.hospital.model.EstadoCitasModelo;

public class EstadoCitasController {

	public Integer CrearEstadoCitas(int id, String estado) throws ClassNotFoundException, SQLException {
		
		EstadoCitasModelo ecm = new EstadoCitasModelo();
		
		return ecm.crearEstadoCita(id, estado);
		
	}
	public List <EstadoCitasDTO> buscarEstadoCita (int id, String estado) throws ClassNotFoundException, SQLException {
		
		EstadoCitasModelo ecm = new EstadoCitasModelo();
		return ecm.buscarEstadoCita(id, estado);
		
	}
	public Integer actualizarEstadoCitas(int id, String estado) throws SQLException, ClassNotFoundException{
		
		EstadoCitasModelo ecm = new EstadoCitasModelo();
		return ecm.actualizarEstadoCitas(id, estado);
	}

}
