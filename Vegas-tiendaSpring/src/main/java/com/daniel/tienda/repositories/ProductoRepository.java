package com.daniel.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.entities.ProductoEntity;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer>{

}
