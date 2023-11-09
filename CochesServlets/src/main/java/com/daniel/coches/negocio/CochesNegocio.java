package com.daniel.coches.negocio;

import java.io.IOException;
import java.text.ParseException;

import com.daniel.coches.modelo.CochesModelo;

public class CochesNegocio {

	public static String obtenerNumeroCoches(String nombre) throws IOException, ParseException {
		CochesModelo modelo = new CochesModelo();
		
		
			int numCoches = modelo.buscarCoche(nombre);
			return "El usuario " + nombre + " tiene " + numCoches + " coches";
		  
	}
}
