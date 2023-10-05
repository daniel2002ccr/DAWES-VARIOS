package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.FarmaciaDTO;
import com.daniel.hospital.model.FarmaciaModelo;

public class FarmaciaController {

	public Integer crearFarmacia(int idFarmacia, String nombreFarmacia, String descripcionFarmacia,
			int cantidadDisponible, float precio) throws ClassNotFoundException, SQLException {
			
		FarmaciaModelo fm = new FarmaciaModelo();
		
		return fm.crearFarmacia(idFarmacia, nombreFarmacia, descripcionFarmacia, cantidadDisponible, precio);
		
	}
	
	public List<FarmaciaDTO> buscarFarmacia(int idFarmacia, String nombreFarmacia, String descripcionFarmacia,
			int cantidadDisponible, float precio) throws ClassNotFoundException, SQLException {
		
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.buscarFarmacia(idFarmacia, nombreFarmacia, descripcionFarmacia, cantidadDisponible, precio);
		
	}
	
	public Integer actualizarFarmacia(int idFarmacia, String nombreFarmacia, String descripcionFarmacia,
			int cantidadDisponible, float precio) throws SQLException, ClassNotFoundException{
		
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.actualizarFarmacia(idFarmacia, nombreFarmacia, descripcionFarmacia, cantidadDisponible, precio);
	}



}
