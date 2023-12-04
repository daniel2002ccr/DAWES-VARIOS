package com.daniel.imc.negocio;

import java.io.IOException;
import java.text.ParseException;

public interface IMCNegocioInterface {
	public double obtenerIMC(String nombre) throws IOException, ParseException;
}
