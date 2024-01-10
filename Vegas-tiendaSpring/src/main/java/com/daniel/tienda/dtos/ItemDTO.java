package com.daniel.tienda.dtos;

public class ItemDTO {

	private Integer clienteID;
	private String clienteNombre;
	private Integer productoID;
	private String productoNombre;
	private Integer cantidad;
	private Double cantidadPagar;

	public ItemDTO(Integer clienteID, String clienteNombre, Integer productoID, String productoNombre, Integer cantidad,
			Double cantidadPagar) {
		super();
		this.clienteID = clienteID;
		this.clienteNombre = clienteNombre;
		this.productoID = productoID;
		this.productoNombre = productoNombre;
		this.cantidad = cantidad;
		this.cantidadPagar = cantidadPagar;
	}

	public Integer getClienteID() {
		return clienteID;
	}

	public void setClienteID(Integer clienteID) {
		this.clienteID = clienteID;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public Integer getProductoID() {
		return productoID;
	}

	public void setProductoID(Integer productoID) {
		this.productoID = productoID;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getCantidadPagar() {
		return cantidadPagar;
	}

	public void setCantidadPagar(Double cantidadPagar) {
		this.cantidadPagar = cantidadPagar;
	}

}
