package com.daniel.tienda.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Categoria")
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Activo")
    private Integer activo;

    @OneToMany(mappedBy = "categoria")
    private Set<ProductoEntity> productos;

    
    
	

	public CategoriaEntity(Integer id, String nombre, String descripcion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public CategoriaEntity() {
		super();
	}
	
	public CategoriaEntity(String nombre, String descripcion, Integer activo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
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

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public Set<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductoEntity> productos) {
		this.productos = productos;
	}



    
}

