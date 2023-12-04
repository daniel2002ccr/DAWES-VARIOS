package com.daniel.coches.negocio;

import java.io.IOException;
import java.text.ParseException;

public interface ICochesNegocio {

	public Integer obtenerNumeroCoches(String nombre) throws IOException, ParseException;
}
