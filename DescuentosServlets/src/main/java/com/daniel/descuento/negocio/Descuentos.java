package com.daniel.descuento.negocio;

import java.io.IOException;

import com.daniel.descuento.modelo.ConsultaDatos;

public class Descuentos {

	public Integer calculaDescuento(String nombre) throws IOException {
		
		ConsultaDatos cd = new ConsultaDatos();
		if(cd.consultaEdad(nombre) < 20 ) {
			return 5;
		}else {
			return 10;
		}

	}
}
