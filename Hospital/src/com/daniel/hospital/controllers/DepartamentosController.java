package com.daniel.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.daniel.hospital.dtos.DepartamentosDTO;
import com.daniel.hospital.model.DepartamentosModelo;

public class DepartamentosController {
	
	
	public Integer crearDepartamento(int idDepartamento, String nombre, String descripcion, int activo) throws ClassNotFoundException, SQLException {
		
		DepartamentosModelo dm = new DepartamentosModelo();
		
		return dm.crearDepartamento(idDepartamento, nombre, descripcion, activo);
		
	}
		
	
	

	public List <DepartamentosDTO> buscarDepartamentos (int idDepartamento, String nombre, String descripcion, int activo) throws ClassNotFoundException, SQLException {
		
		DepartamentosModelo dm = new DepartamentosModelo();
		
		return dm.buscarDepartamentos(idDepartamento, nombre, descripcion, activo);
		
	}
	
	public Integer actualizarDepartamentos(int idDepartamento, String nombre, String descripcion, int activo) throws SQLException, ClassNotFoundException{
		
		DepartamentosModelo dm = new DepartamentosModelo();
		
		return dm.actualizarDepartamentos(idDepartamento, nombre, descripcion, activo);
	}

	public Integer borrarDepartamentos(int idDepartamento, int activo) throws ClassNotFoundException, SQLException{
		
		DepartamentosModelo dm = new DepartamentosModelo();
		
		return dm.borrarDepartamentos(idDepartamento, activo);
	}
	
}
