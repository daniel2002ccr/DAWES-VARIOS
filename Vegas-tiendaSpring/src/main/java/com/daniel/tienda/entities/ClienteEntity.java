package com.daniel.tienda.entities;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cliente")
    private Integer id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "CorreoElectronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_poblacion")
    private PoblacionEntity poblacion;

    @Column(name = "activo")
    private Integer activo;

	public ClienteEntity(Integer id, String nombre, String correoElectronico, String password,
			PoblacionEntity poblacion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.password = password;
		this.poblacion = poblacion;
		this.activo = activo;
	}

	public ClienteEntity() {
		super();
	}
	
	

	public ClienteEntity(Integer id, String nombre, String correoElectronico, PoblacionEntity poblacion,
			Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.poblacion = poblacion;
		this.activo = activo;
	}

	public ClienteEntity(String nombre, String correoElectronico, PoblacionEntity poblacion, Integer activo) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.poblacion = poblacion;
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

	public PoblacionEntity getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(PoblacionEntity poblacion) {
		this.poblacion = poblacion;
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

