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
    private int id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private BigDecimal precio;

    @Column(name = "CantidadEnStock")
    private Integer cantidadEnStock;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria")
    private CategoriaEntity categoria;



//    @ManyToOne
//    @JoinColumn(name = "ID_Proveedor")
//    private Proveedor proveedor;
//
//    @OneToMany(mappedBy = "producto")
//    private Set<Peticion> peticiones;

//    @OneToMany(mappedBy = "producto")
//    private Set<DetallePedido> detallePedidos;

    // Getters y setters...
}
