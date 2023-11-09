package com.daniel.coches.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CochesModelo {

	String path = Thread.currentThread().getContextClassLoader().getResource("coches.txt").getPath();

	File f = new File(path);

	public List<String> buscarCoche(String nombre) throws IOException, ParseException {
		List<String> nombres = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader(f));
		String linea;

		while ((linea = reader.readLine()) != null) {
			String[] partes = linea.split("-");
			String nombreEnFichero = partes[0];
			
			if (!nombres.contains(nombreEnFichero)) {
                nombres.add(nombreEnFichero);
            }

		}
		
		reader.close();
		return nombres;
	}
}
