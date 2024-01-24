package com.daniel.tienda.dtos;

public class PedidosDTO {

	private Integer id;
	private Integer id_cliente;
	private String nombre_cliente;
	private Integer id_producto;
	private String nombre_producto;
	private String fecha;
	private Integer estado;
	private String estado_nombre;

	

	public PedidosDTO(Integer id, Integer id_cliente, String nombre_cliente, Integer id_producto,
			String nombre_producto, String fecha, Integer estado, String estado_nombre) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.nombre_cliente = nombre_cliente;
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.fecha = fecha;
		this.estado = estado;
		this.estado_nombre = estado_nombre;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getEstado_nombre() {
		return estado_nombre;
	}

	public void setEstado_nombre(String estado_nombre) {
		this.estado_nombre = estado_nombre;
	}

}
