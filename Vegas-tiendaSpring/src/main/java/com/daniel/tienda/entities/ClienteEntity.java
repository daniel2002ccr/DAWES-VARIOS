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

    // ...otros campos...

//    @OneToMany(mappedBy = "cliente")
//    private Set<Pedido> pedidos;
//
//    @OneToMany(mappedBy = "cliente")
//    private Set<Peticion> peticiones;

    // Getters y setters...
}

