package com.daniel.coches.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class CochesModelo implements ICocheModelo{
	public List<String> buscarCoche(String nombre) throws IOException, ParseException {
		File f = ResourceUtils.getFile("classpath:coches.txt");
		List<String> nombres = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader(f));
		String linea;

		while ((linea = reader.readLine()) != null) {
			String[] partes = linea.split("-");
			String nombreEnFichero = partes[0];
		
            nombres.add(nombreEnFichero);
 
		}
		
		reader.close();
		return nombres;
	}
}