package com.daniel.colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daniel.colegio.dtos.AlumnoDTO;
import com.daniel.colegio.entities.AlumnoEntity;

@Repository
public interface AlumnosRepository extends CrudRepository<AlumnoEntity, Integer>{

	@Query(value="SELECT new com.daniel.colegio.dtos.AlumnoDTO(a.id, a.nombre, a.apellidos, a.municipio.nombre, a.municipio.idMunicipio, a.famNumerosa, a.activo) "
			+ "FROM com.daniel.colegio.entities.AlumnoEntity a "
			+ "WHERE CAST (a.id as String) LIKE CONCAT ('%', :id, '%') AND a.nombre LIKE CONCAT ('%', :nombre, '%') "
			+ "AND a.apellidos LIKE CONCAT ('%', :apellido, '%') "
			+ "AND a.activo = :activo "
			+ "AND  a.famNumerosa = :famNumerosa ")
	public List<AlumnoDTO> buscaAlumnos(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("apellido") String apellido,
			@Param("activo") Integer activo,
			@Param("famNumerosa") Integer familiaNumerosa);
}
