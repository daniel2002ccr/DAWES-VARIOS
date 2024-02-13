package com.daniel.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.entities.ProductoEntity;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer>{

	
	@Query(value= "select new com.daniel.tienda.dtos.ProductoDTO(p.id, p.nombre, p.descripcion, p.precio, p.cantidadEnStock, c.nombre, pr.nombre, c.id,  pr.id) "
            + " from ProductoEntity p, CategoriaEntity c, ProveedoresEntity pr "
            + " where p.categoria.id = c.id "
            + " and p.proveedores.id = pr.id "
            + " and (CAST (p.id as STRING) like concat ('%', :id, '%') or :id is null) "
            + " and p.nombre like concat ('%', :nombre, '%')"
            + " and p.descripcion like concat ('%', :descripcion, '%')"
            + " and p.precio >= :precio "
            + " and p.cantidadEnStock >= :cantidadEnStock "
            + " and (CAST (p.categoria.id as STRING) like concat ('%', :categoria, '%') or :categoria is null) "
            + " and CAST (p.proveedores.id as STRING) like concat ('%', :proveedores, '%') or :proveedores is null ")
	
	public List<ProductoDTO> buscarProducto(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("precio") String precio,
			@Param("cantidadEnStock") String cantidadEnStock,
			@Param("categoria") String categoria,
			@Param("proveedores") String proveedores);
}
