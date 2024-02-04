package com.daniel.tienda.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "peticiones")
public class PeticioneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Peticiones")
	private Integer idPeticiones;

	@Column(name = "FechaAñadido")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAnadido;
	
	@Column(name = "Cantidad")
    private Integer cantidad;
}
