package com.daniel.tienda.entities;


import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cliente")
    private int id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "CorreoElectronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "password")
    private String password;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Column(name = "ID_Poblacion")
    private Integer idPoblacion;

    @Column(name = "activo")
    private Integer activo;

	public ClienteEntity(int id, String nombre, String correoElectronico, String password, Date fechaRegistro,
			Integer idPoblacion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
		this.idPoblacion = idPoblacion;
		this.activo = activo;
	}

	public ClienteEntity(String nombre, String correoElectronico, Integer idPoblacion, Integer activo) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.idPoblacion = idPoblacion;
		this.activo = activo;
	}

	public ClienteEntity() {
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getIdPoblacion() {
		return idPoblacion;
	}

	public void setIdPoblacion(Integer idPoblacion) {
		this.idPoblacion = idPoblacion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
    
    

    // ...otros campos...

//    @OneToMany(mappedBy = "cliente")
//    private Set<Pedido> pedidos;
//
//    @OneToMany(mappedBy = "cliente")
//    private Set<Peticion> peticiones;

    // Getters y setters...
}

