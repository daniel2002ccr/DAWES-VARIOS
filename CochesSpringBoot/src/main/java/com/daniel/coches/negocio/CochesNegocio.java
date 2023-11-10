package com.daniel.coches.negocio;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.daniel.coches.modelo.ICocheModelo;


@Component
public class CochesNegocio implements ICochesNegocio{

	@Autowired
	ICocheModelo coche;
	public Integer obtenerNumeroCoches(String nombre) throws IOException, ParseException {
		 List<String> lineas = coche.buscarCoche(nombre);
		 int coches = numeroCoches(lineas, nombre);
	
		return coches;
	}

	private int numeroCoches(List <String> linea, String nombre) {
		int contador = 0;
		for (String lineas: linea) {
			if (lineas.contains(nombre)) {
				contador++;
			}
		}
		return contador;
		
	}
}
