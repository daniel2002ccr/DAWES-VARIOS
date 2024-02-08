package com.daniel.tienda.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "peticiones")
public class PeticionesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Peticiones")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProductoEntity producto;

	@Column(name = "FechaAñadido")
	private String fecha;

	@Column(name = "Cantidad")
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "estado")
	private EstadoPedidosEntity estados;

	public PeticionesEntity(Integer id, ClienteEntity cliente, ProductoEntity producto, String fecha, Integer cantidad,
			EstadoPedidosEntity estados) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.estados = estados;
	}
	

	public PeticionesEntity(ClienteEntity cliente, ProductoEntity producto, Integer cantidad,
			EstadoPedidosEntity estados) {
		super();
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.estados = estados;
	}


	public PeticionesEntity(Integer id, ClienteEntity cliente, ProductoEntity producto, Integer cantidad,
			EstadoPedidosEntity estados) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.estados = estados;
	}


	public PeticionesEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
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

	public EstadoPedidosEntity getEstados() {
		return estados;
	}

	public void setEstados(EstadoPedidosEntity estados) {
		this.estados = estados;
	}

}
