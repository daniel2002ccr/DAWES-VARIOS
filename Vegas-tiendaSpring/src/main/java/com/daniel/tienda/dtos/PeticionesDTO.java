package com.daniel.tienda.dtos;

public class PeticionesDTO {

	private Integer id;
	private Integer id_cliente;
	private Integer id_producto;
	private String cantidad;
	private Integer id_estado;
	private String fecha;

	public PeticionesDTO(Integer id, Integer id_cliente, Integer id_producto, String cantidad, Integer id_estado,
			String fecha) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.id_estado = id_estado;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
