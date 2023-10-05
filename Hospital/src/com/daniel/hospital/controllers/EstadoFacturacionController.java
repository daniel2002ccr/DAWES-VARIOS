package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.EstadoFacturacionDTO;
import com.daniel.hospital.model.EstadoFacturacionModelo;



public class EstadoFacturacionController {
public Integer CrearEstadoFactura(int id, String estado) throws ClassNotFoundException, SQLException {
		
		EstadoFacturacionModelo efm = new EstadoFacturacionModelo();
		
		return efm.crearEstadoFactura(id, estado);
		
	}
	public List <EstadoFacturacionDTO> buscarEstadoFactura (int id, String estado) throws ClassNotFoundException, SQLException {
		
		EstadoFacturacionModelo efm = new EstadoFacturacionModelo();
		return efm.buscarEstadoFacturacion(id, estado);
		
	}
	public Integer actualizarEstadoFactura(int id, String estado) throws SQLException, ClassNotFoundException{
		
		EstadoFacturacionModelo efm = new EstadoFacturacionModelo();
		return efm.actualizarEstadoFacturacion(id, estado);
	}
}
