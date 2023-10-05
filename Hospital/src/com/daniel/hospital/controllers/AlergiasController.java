package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.AlergiaDTO;
import com.daniel.hospital.model.AlergiasModelo;

public class AlergiasController {
	

	
	public List<AlergiaDTO> buscarAlergias(String id, String nombre) throws ClassNotFoundException, SQLException{
		AlergiasModelo am = new AlergiasModelo();
		return am.buscaAlergia(id, nombre);
	}
	
	
	public Integer insertarAlergia(String nombreAlergia) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.insertarAlergia(nombreAlergia);
	}
	
	public Integer actualizarAlergia(Integer id, String nombreAlergia) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.actualizarAlergia(id, nombreAlergia);
	}
	
	public Integer borrarCliente(int numerocliente) throws ClassNotFoundException, SQLException {
		
		AlergiasModelo cm = new AlergiasModelo();
		return cm.borrarCliente(numerocliente);
	}

}
