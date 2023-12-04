package com.daniel.imc.modelo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IMCModeloInterface {

	public List<String> buscarNombre(String nombre) throws IOException, ParseException;
}
