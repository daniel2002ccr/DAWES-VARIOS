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
@Table(name = "poblacion")
public class PoblacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "poblacion")
    private Set<ClienteEntity> clientes;

	public PoblacionEntity(int id, String nombre, Set<ClienteEntity> clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clientes = clientes;
	}

	public PoblacionEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(Set<ClienteEntity> clientes) {
		this.clientes = clientes;
	}
    
    
}

