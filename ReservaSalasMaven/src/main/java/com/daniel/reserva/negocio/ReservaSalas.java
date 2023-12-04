package com.daniel.reserva.negocio;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ReservaSalas {
	
	private static final String RUTA_ARCHIVO_RESERVAS = "C:\\Users\\Usuario\\Desktop\\DAWES\\DAWES-VARIOS\\ReservaSalasMaven\\src\\main\\resources\\reserva\\reservas.txt";


	public boolean esFechaValida(String fechaHora) throws ParseException {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	    Date fecha = sdf.parse(fechaHora);
	    Date now = new Date();
	    return !fecha.before(now);
	}
	
	public boolean esHoraEnPunto(String fechaHora) {
		 LocalDateTime ldt = LocalDateTime.parse(fechaHora);
	        
	        if (ldt.getMinute() != 0) {
	            System.out.println("La hora debe ser en punto");
	            return false;
	        }
	        return true;
    }

	public int generarCodigoConfirmacion() {
	    Random random = new Random();
	    return random.nextInt(300); 
	     
	}
	
	public boolean esSalaDisponible(String tipo, String fechaHora) throws IOException, ParseException {
        
        BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO_RESERVAS));
        String linea;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date fechaHoraReserva = sdf.parse(fechaHora);
        
        

        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(";");
            String tipoReserva = partes[2];
            String fechaHoraReservaStr = partes[1];
            Date fechaHoraReservaExistente = sdf.parse(fechaHoraReservaStr);

            if (partes.length != 3) {
                System.out.println("Error en el formato de la línea: " + linea);
                continue;
            }
            
            if (tipoReserva.equals(tipo) && fechaHoraReserva.equals(fechaHoraReservaExistente)) {
                reader.close();
                return false; 
            }
        }

        reader.close();
        return true; 
    }
	public List<String> buscarAlternativas(String tipo, String fechaHora) throws IOException, ParseException {
	    List<String> alternativas = new ArrayList<>();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	    Date fechaHoraReserva = sdf.parse(fechaHora);

	    BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO_RESERVAS));
	    String linea;
	    while ((linea = br.readLine()) != null) {
	        String[] partes = linea.split(";");
	        if (partes.length == 3) {
	            String tipoReserva = partes[2];
	            String fechaHoraReservaStr = partes[1];
	            Date fechaHoraReservaExistente = sdf.parse(fechaHoraReservaStr);

	            if (tipoReserva.equals("Sala de Juntas") && fechaHoraReserva.equals(fechaHoraReservaExistente)) {
	                	 alternativas.add("Sala de Conferencias");
	                     alternativas.add("Oficina Privada");
	                }
	             else if (tipoReserva.equals("Sala de Conferencias") && fechaHoraReserva.equals(fechaHoraReservaExistente)) {
	                    alternativas.add("Sala de Juntas");
	                    alternativas.add("Oficina Privada");
	                }
	             else if (tipoReserva.equals("Oficina Privada") && fechaHoraReserva.equals(fechaHoraReservaExistente)) {
	            	 	alternativas.add("Sala de Juntas");
	            	 	alternativas.add("Sala de Conferencias");
	            	 	
	                }
	        }
	}
	    br.close();
	    return alternativas;
	}


	public void guardarReservaEnArchivo(String datosReserva) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_RESERVAS, true));
        wr.write(datosReserva);
        wr.newLine();
        wr.close();
    }
}

