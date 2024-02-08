package com.daniel.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.dtos.CategoriaDTO;
import com.daniel.tienda.entities.CategoriaEntity;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Integer> {

	@Query(value= "SELECT NEW com.daniel.tienda.dtos.CategoriaDTO (c.id, c.nombre, c.descripcion, c.activo)"
			+ " FROM com.daniel.tienda.entities.CategoriaEntity c"
			+ " WHERE CAST (c.id as STRING) LIKE CONCAT ('%', :id, '%')"
			+ " AND c.nombre LIKE CONCAT ('%', :nombre, '%')"
			+ " AND c.descripcion LIKE CONCAT ('%', :descripcion, '%')"
			+ " AND c.activo = :activo")
	
	public List<CategoriaDTO> buscarCategoria(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("activo") Integer activo);
}
