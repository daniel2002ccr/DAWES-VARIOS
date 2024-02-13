package com.daniel.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.dtos.ProveedoresDTO;
import com.daniel.tienda.entities.ProveedoresEntity;

@Repository
public interface ProveedoresRepository extends CrudRepository<ProveedoresEntity, Integer>{

	@Query(value="SELECT NEW com.daniel.tienda.dtos.ProveedoresDTO (p.idProveedor, p.nombre, p.contacto, p.telefono, p.correoElectronico, p.direccion, p.activo)"
			+ " FROM com.daniel.tienda.entities.ProveedoresEntity p"
			+ " WHERE CAST (p.idProveedor as STRING) LIKE CONCAT ('%', :idProveedor, '%')"
			+ " AND p.nombre LIKE CONCAT ('%', :nombre, '%')"
			+ " AND p.contacto LIKE CONCAT ('%', :contacto, '%')"
			+ " AND p.telefono LIKE CONCAT ('%', :telefono, '%')"
			+ " AND p.correoElectronico LIKE CONCAT ('%', :correoElectronico, '%')"
			+ " AND p.direccion LIKE CONCAT ('%', :direccion, '%')"
			+ " AND p.activo = :activo")
	public List<ProveedoresDTO> buscarProveedor(@Param("idProveedor") String id,
			@Param("nombre") String nombre,
			@Param("contacto") String contacto,
			@Param("telefono") String telefono,
			@Param("correoElectronico") String correoElectronico,
			@Param("direccion") String direccion,
			@Param("activo") Integer activo);
}
