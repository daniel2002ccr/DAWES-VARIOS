package com.daniel.tienda.dtos;

public class ProductoDTO {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer cantidadStock;
	private Integer categoria;
	private Integer proveedor;

	public ProductoDTO(Integer id, String nombre, String descripcion, Double precio, Integer cantidadStock,
			Integer categoria, Integer proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadStock = cantidadStock;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}

}
