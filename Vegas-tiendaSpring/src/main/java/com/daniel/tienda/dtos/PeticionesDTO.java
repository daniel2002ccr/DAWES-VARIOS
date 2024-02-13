package com.daniel.tienda.dtos;

public class PeticionesDTO {

	private Integer id;
	private String nombre_cliente;
	private String nombre_producto;
	private String fecha;
	private Integer cantidad;
	private String nombre_estado;
	private Integer id_cliente;
	private Integer id_estado;
	private Integer id_producto;
	

	public PeticionesDTO(Integer id, Integer id_cliente, String nombre_cliente, Integer id_producto,
			String nombre_producto, String fecha, Integer cantidad, Integer id_estado, String nombre_estado) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.nombre_cliente = nombre_cliente;
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.id_estado = id_estado;
		this.nombre_estado = nombre_estado;
	}
	

	public PeticionesDTO(Integer id, String nombre_cliente, String nombre_producto, String fecha, Integer cantidad,
			String nombre_estado, Integer id_cliente, Integer id_estado, Integer id_producto) {
		super();
		this.id = id;
		this.nombre_cliente = nombre_cliente;
		this.nombre_producto = nombre_producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.nombre_estado = nombre_estado;
		this.id_cliente = id_cliente;
		this.id_estado = id_estado;
		this.id_producto = id_producto;
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

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

}
