package com.daniel.imc.modelo;

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
public class IMCModelo implements IMCModeloInterface{

	

	public List<String> buscarNombre(String nombre) throws IOException, ParseException {
		List<String> nombres = new ArrayList<>();
		File f = ResourceUtils.getFile("classpath:coches.txt");
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String linea;

		while ((linea = reader.readLine()) != null) {
			String[] partes = linea.split("-");
			String nombreEnFichero = partes[0];
			if (nombreEnFichero.equals(nombre)) {
	            nombres.add(linea);
	        }
 
		}
		
		reader.close();
		return nombres;
	}
}
