package com.daniel.descuento.negocio;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.descuento.modelo.ConsultaDatos;
import com.daniel.descuento.modelo.IConsultaDatos;

@Component
public class Descuentos implements IDescuentos{
	@Autowired
	IConsultaDatos consultadatos;
	public Integer calculaDescuento(String nombre) throws IOException {
		
//		ConsultaDatos cd = new ConsultaDatos();
		if(consultadatos.consultaEdad(nombre) < 20 ) {
			return 5;
		}else {
			return 10;
		}

	}
}
