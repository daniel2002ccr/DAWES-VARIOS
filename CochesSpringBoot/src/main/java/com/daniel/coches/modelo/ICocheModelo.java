package com.daniel.coches.modelo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface ICocheModelo {

	public List<String> buscarCoche(String nombre) throws IOException, ParseException;
}
