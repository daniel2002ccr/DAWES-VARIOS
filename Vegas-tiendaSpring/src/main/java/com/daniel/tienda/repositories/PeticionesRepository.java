package com.daniel.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.daniel.tienda.dtos.PeticionesDTO;
import com.daniel.tienda.entities.PeticionesEntity;

public interface PeticionesRepository extends CrudRepository<PeticionesEntity, Integer>{

	
	@Query(value= "select new com.daniel.tienda.dtos.PeticionesDTO(p.id , c.nombre, pr.nombre, p.fecha, p.cantidad, ep.nombre, c.id, pr.id, ep.id ) "
            + " from PeticionesEntity p, "
            + " ClienteEntity c, ProductoEntity pr, EstadoPedidosEntity ep "
            + " where p.cliente.id = c.id "
            + " and p.producto.id = pr.id "
            + " and p.estados.id = ep.id "
            + " and (cast (p.id as string) like concat ('%', :id, '%') or :id is null) "
            + " and (cast (p.cliente.id as string) like concat ('%', :cliente, '%') or :cliente is null) "
            + " and (cast (p.producto.id as string) like concat ('%', :producto, '%') or :producto is null) " 
            + " and p.fecha >= :fecha "
            + " and p.cantidad >= :cantidad "
            + " and (cast (p.estados.id as string) like concat ('%', :estados, '%') or :estados is null)")
	
	public List<PeticionesDTO> buscarPeticion(@Param("id") String id,
			@Param("cliente") String cliente,
			@Param("producto") String producto,
			@Param("fecha") String fecha,
			@Param("cantidad") String cantidad,
			@Param("estados") String estados);
}
