package com.daniel.descuento.modelo;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component("consultaBBDD")
public class ConsultaBBDD implements IConsultaDatos{

	@Override
	public Integer consultaEdad(String nombre) throws IOException {
		System.out.println("Me conecto a la BBDD y obtengo el valor");
		return 40;
	}

	
}
