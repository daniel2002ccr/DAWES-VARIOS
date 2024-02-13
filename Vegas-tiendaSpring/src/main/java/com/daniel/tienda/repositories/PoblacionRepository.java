package com.daniel.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.entities.PoblacionEntity;

@Repository
public interface PoblacionRepository extends CrudRepository<PoblacionEntity, Integer>{

}
