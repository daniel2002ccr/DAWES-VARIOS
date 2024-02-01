package com.daniel.tienda.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "proveedores")
public class ProveedoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_proveedor")
    private Integer idProveedor;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "telefono")
    private String telefono;
 
    
    @Column(name = "correoElectronico")
    private String correoElectronico;

    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "activo")
    private Integer activo;

    @OneToMany(mappedBy = "proveedores")
    private Set<ProductoEntity> productos;
    
    

    public ProveedoresEntity() {
        super();
    }

    public ProveedoresEntity(Integer idProveedor, String nombre, String contacto, String telefono,
            String correoElectronico, String direccion, Integer activo) {
        super();
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.activo = activo;
    }

    public ProveedoresEntity(Integer idProveedor, String nombre, String contacto, String telefono,
            String correoElectronico, String direccion, Integer activo, Set<ProductoEntity> productos) {
        super();
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.activo = activo;
        this.productos = productos;
    }

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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