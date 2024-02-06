package com.daniel.colegio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.colegio.entities.MunicipioEntity;

@Repository
public interface MunicipioRepository extends CrudRepository<MunicipioEntity, Integer>{

	
}
