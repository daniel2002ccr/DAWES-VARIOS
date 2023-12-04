package com.danielvegas.hora.negocio;

import java.util.Date;

public class Hora {
	    public String obtenerFechaYHoraActual() {
	        Date fechaHoraActual = new Date();
	        return fechaHoraActual.toString();
	    }
}
