package com.daniel.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.entities.ClienteEntity;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer>{

	@Query(value= "select new com.daniel.tienda.dtos.ClientesDTO(c.id, c.nombre, c.correoElectronico, p.nombre, p.id, c.activo) "
			+ " from ClienteEntity c, PoblacionEntity p WHERE c.poblacion.id = p.id "
			+ " and (CAST (c.id as String) like concat ('%', :id, '%') or :id is null) "
			+ " and  c.nombre like concat ('%', :nombre, '%')"
			+ " and c.correoElectronico like concat ('%', :correoElectronico, '%')"
			+ " and(CAST (c.poblacion.id as STRING) like concat ('%', :poblacion, '%') or :poblacion is null) "
			+ " and c.activo = :activo ")
	
	public List<ClientesDTO> buscarCliente(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("correoElectronico") String correoElectronico,
			@Param("poblacion") String poblacion,
			@Param("activo") Integer activo);
}
