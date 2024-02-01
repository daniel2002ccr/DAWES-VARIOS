package com.daniel.tienda.entities;


import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Producto")
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private Double precio;

    @Column(name = "CantidadEnStock")
    private Integer cantidadEnStock;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "ID_Proveedor")
    private ProveedoresEntity proveedores;

	public ProductoEntity(Integer id, String nombre, String descripcion, Double precio, Integer cantidadEnStock,
			CategoriaEntity categoria, ProveedoresEntity proveedores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedores = proveedores;
	}

	public ProductoEntity() {
		super();
	}

	public ProductoEntity(String nombre, String descripcion, Double precio, Integer cantidadEnStock,
			CategoriaEntity categoria, ProveedoresEntity proveedores) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedores = proveedores;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public ProveedoresEntity getProveedores() {
		return proveedores;
	}

	public void setProveedores(ProveedoresEntity proveedores) {
		this.proveedores = proveedores;
	}
    
    

//    @OneToMany(mappedBy = "producto")
//    private Set<Peticion> peticiones;

//    @OneToMany(mappedBy = "producto")
//    private Set<DetallePedido> detallePedidos;

    // Getters y setters...
}
