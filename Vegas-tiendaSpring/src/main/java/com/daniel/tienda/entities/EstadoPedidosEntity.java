package com.daniel.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "estadospedidos")
public class EstadoPedidosEntity {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "EstadoID")
	    private Integer id;
	 	
	 	@Column(name = "nombreEstado", nullable= false)
	 	private String nombre;
	 	
	 	@OneToMany(mappedBy="estados")
	 	private Set<PeticionesEntity> peticiones;

		public EstadoPedidosEntity(Integer id, String nombre, Set<PeticionesEntity> peticiones) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.peticiones = peticiones;
		}

		public EstadoPedidosEntity() {
			super();
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

		public Set<PeticionesEntity> getPeticiones() {
			return peticiones;
		}

		public void setPeticiones(Set<PeticionesEntity> peticiones) {
			this.peticiones = peticiones;
		}

	 	

}
