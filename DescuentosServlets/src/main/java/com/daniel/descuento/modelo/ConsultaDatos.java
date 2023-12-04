package com.daniel.descuento.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaDatos {

	public Integer consultaEdad(String nombre) throws IOException {
		
		File f = new File("C:\\Users\\alumnofp\\Documents\\fichero.txt");
		BufferedReader lector = new BufferedReader(new FileReader(f));
		String linea;
		
		while((linea=lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				String[] arrayPersona = linea.split("-");
				return Integer.parseInt(arrayPersona[1]);
			}
		}
		
		return null;
	}
}
