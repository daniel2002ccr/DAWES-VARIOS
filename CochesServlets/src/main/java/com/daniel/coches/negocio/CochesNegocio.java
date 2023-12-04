package com.daniel.coches.negocio;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import com.daniel.coches.modelo.CochesModelo;

public class CochesNegocio {

	public Integer obtenerNumeroCoches(String nombre) throws IOException, ParseException {
		 CochesModelo cochesModelo = new CochesModelo();
		 List<String> lineas = cochesModelo.buscarCoche(nombre);
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
