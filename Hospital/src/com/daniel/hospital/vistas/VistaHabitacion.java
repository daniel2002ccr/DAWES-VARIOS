package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.HabitacionesController;
import com.daniel.hospital.dtos.HabitacionDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaHabitacion {

	public void menuHabitacion() throws ClassNotFoundException, SQLException  {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE HABITACION");
	    System.out.println("===============================================");
	    System.out.println("1. Buscar habitacion");
	    System.out.println("2. Insertar habitacion");
	    System.out.println("3. Actualizar habitacion");
	    System.out.println("4. Volver al menu principal");
	    System.out.println("===============================================");
	    
	    n = Integer.parseInt(sc.nextLine());
	    
	    if (n>4||n<1){
            System.out.print("Elección invalida, inténtalo otra vez...");
            continue;
        }
        if (n == 1) {
        recuperaHabitacion();
        }
        
        if ( n== 2) {
        menuInsertaHabitacion();
        }
        
        if (n == 3) {
        menuActualizaHabitacion();
        }
        if (n == 4) {
        MenuPrincipal m = new MenuPrincipal();
        m.menuPrincipal();
        }
    
    
	} while (n != 4);
}
	public void recuperaHabitacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la habitacion: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca por favor el tipo de habitacion: ");
		String tipo = sc.nextLine();
		System.out.println("Introduzca por favor el estado de la habitacion: ");
		String estado = sc.nextLine();
		System.out.println("Introduzca por favor el coste del día: ");
		Float coste = sc.nextFloat();
		sc.nextLine();
		HabitacionesController hc = new HabitacionesController();
		List<HabitacionDTO> listaHabitacion = hc.buscarHabitacion(id, tipo, estado, coste);
	
		for (HabitacionDTO habitacion : listaHabitacion) {
			System.out.println(habitacion.toString());
		}
	}
	
	public void menuInsertaHabitacion() throws ClassNotFoundException, SQLException {
		
	
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la habitacion: ");
		Integer habId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca por favor el tipo de habitacion: ");
		String tipo = sc.nextLine();
		
		System.out.println("Introduzca por favor el estado de habitacion: ");
		String estado = sc.nextLine();
		
		System.out.println("Introduzca por favor el coste del dia: ");
		Float costeDia = sc.nextFloat();
		sc.nextLine();
		
		HabitacionesController hc = new HabitacionesController();
		
		hc.crearHabitacion(habId, tipo, estado, costeDia);
}
	public void menuActualizaHabitacion() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el id de la habitacion: ");
		Integer habId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca por favor el tipo de habitacion: ");
		String tipo = sc.nextLine();
		
		System.out.println("Introduzca por favor el estado de habitacion: ");
		String estado = sc.nextLine();
		
		System.out.println("Introduzca por favor el coste del dia: ");
		Float costeDia = sc.nextFloat();
		sc.nextLine();

		HabitacionesController hc = new HabitacionesController();
		hc.actualizarHabitacion(habId, tipo, estado, costeDia);
	}
}
