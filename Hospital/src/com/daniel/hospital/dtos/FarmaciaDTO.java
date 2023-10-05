package com.daniel.hospital.dtos;

public class FarmaciaDTO {

	private int idFarmacia;
	private String nombreFarmacia;
	private String descripcionFarmacia;
	private int cantidadDisponible;
	private float precio;
	
	
	public FarmaciaDTO(int idFarmacia, String nombreFarmacia, String descripcionFarmacia, int cantidadDisponible,
			float precio) {
		super();
		this.idFarmacia = idFarmacia;
		this.nombreFarmacia = nombreFarmacia;
		this.descripcionFarmacia = descripcionFarmacia;
		this.cantidadDisponible = cantidadDisponible;
		this.precio = precio;
	}


	public int getIdFarmacia() {
		return idFarmacia;
	}


	public void setIdFarmacia(int idFarmacia) {
		this.idFarmacia = idFarmacia;
	}


	public String getNombreFarmacia() {
		return nombreFarmacia;
	}


	public void setNombreFarmacia(String nombreFarmacia) {
		this.nombreFarmacia = nombreFarmacia;
	}


	public String getDescripcionFarmacia() {
		return descripcionFarmacia;
	}


	public void setDescripcionFarmacia(String descripcionFarmacia) {
		this.descripcionFarmacia = descripcionFarmacia;
	}


	public int getCantidadDisponible() {
		return cantidadDisponible;
	}


	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "FarmaciaDTO [idFarmacia=" + idFarmacia + ", nombreFarmacia=" + nombreFarmacia + ", descripcionFarmacia="
				+ descripcionFarmacia + ", cantidadDisponible=" + cantidadDisponible + ", precio=" + precio + "]";
	}
	
	
}
