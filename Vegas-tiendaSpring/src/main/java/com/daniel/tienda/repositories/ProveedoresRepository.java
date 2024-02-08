package com.daniel.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.entities.ProveedoresEntity;

@Repository
public interface ProveedoresRepository extends CrudRepository<ProveedoresEntity, Integer>{

}
