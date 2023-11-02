package com.daniel.reserva.negocio;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservaSalas {

	private boolean esFechaValida(String fechaHora) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setLenient(false);
     
            Date fecha = sdf.parse(fechaHora);
            Date now = new Date(); 
            return !fecha.before(now); 
       
	}
	private boolean esHoraEnPunto(String fechaHora) {
        String[] fecha = fechaHora.split(" ");
        String hora = fecha[1]; 
        String[] partesHora = hora.split(":");
        int minutos = Integer.parseInt(partesHora[1]);
        return minutos == 0; 
    }

}
