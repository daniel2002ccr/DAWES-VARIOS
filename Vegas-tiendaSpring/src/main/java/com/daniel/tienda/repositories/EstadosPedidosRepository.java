package com.daniel.tienda.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.tienda.entities.EstadoPedidosEntity;

@Repository
public interface EstadosPedidosRepository extends CrudRepository<EstadoPedidosEntity, Integer>{

}
