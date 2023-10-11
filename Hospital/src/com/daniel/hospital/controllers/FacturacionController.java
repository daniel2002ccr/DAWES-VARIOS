package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.FacturacionDTO;
import com.daniel.hospital.model.FacturacionModelo;

public class FacturacionController {

	public Integer crearFacturacion(String pacienteNombre, String fecha, float monto, String estado)
			throws ClassNotFoundException, SQLException {
		
		FacturacionModelo fm = new FacturacionModelo();
		return fm.crearFacturacion(pacienteNombre, fecha, monto, estado);
	}
	
	public List<FacturacionDTO> buscarFacturacion(int id, String pacienteNombre, String fecha, float monto, String estado) throws ClassNotFoundException, SQLException {
		
		FacturacionModelo fm = new FacturacionModelo();
		return fm.buscarFacturacion(id, pacienteNombre, fecha, monto, estado);
	}
	
	public Integer actualizaFacturacion (int id, String pacienteNombre, String fecha, float monto, String estado)  throws ClassNotFoundException, SQLException{
		
		FacturacionModelo fm = new FacturacionModelo();
		return fm.actualizaFacturacion(id, pacienteNombre, fecha, monto, estado); 
	}

}
