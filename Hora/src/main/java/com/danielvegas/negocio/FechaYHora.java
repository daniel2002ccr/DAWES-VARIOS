package com.danielvegas.negocio;

import java.util.Date;

public class FechaYHora {
    public String obtenerFechaYHoraActual() {
        Date fechaHoraActual = new Date();
        return fechaHoraActual.toString();
    }
}

