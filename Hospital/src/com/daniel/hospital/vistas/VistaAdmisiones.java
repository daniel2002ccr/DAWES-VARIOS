package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.AdmisionesController;
import com.daniel.hospital.dtos.AdmisionesDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaAdmisiones {

	public void menuAdmision() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE ADMISIONES");
			System.out.println("===============================================");
			System.out.println("1. Buscar admision");
			System.out.println("2. Insertar admision");
			System.out.println("3. Actualizar admision");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				buscarAdmision();
			}

			if (n == 2) {
				crearAdmision();
			}

			if (n == 3) {
				actualizarAdmision();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
}
	
public void crearAdmision() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre del paciente");
		String nombreP = sc.nextLine();
		System.out.println("Introduzca el tipo de habitacion ");
		String habitacion = sc.nextLine();
		System.out.println("Introduzca la fecha de ingreso");
		String fechaIngreso = sc.nextLine();
		System.out.println("Introduzca la fecha de salida ");
		String fechaSalida = sc.nextLine();
		System.out.println("Introduzca el motivo ");
		String motivo = sc.nextLine();
		
		AdmisionesController ac = new AdmisionesController();
		ac.creaAdmision(nombreP, habitacion, fechaIngreso, fechaSalida, motivo);
}

public void actualizarAdmision() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca el id de la cita");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca el tipo de habitacion ");
	String habitacion = sc.nextLine();
	System.out.println("Introduzca la fecha de ingreso");
	String fechaIngreso = sc.nextLine();
	System.out.println("Introduzca la fecha de salida ");
	String fechaSalida = sc.nextLine();
	System.out.println("Introduzca el motivo ");
	String motivo = sc.nextLine();
	
	AdmisionesController ac = new AdmisionesController();
	ac.actualizaAdmision(id, nombreP, habitacion, fechaIngreso, fechaSalida, motivo);
}

public void buscarAdmision() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca el id de la cita");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca el tipo de habitacion ");
	String habitacion = sc.nextLine();
	System.out.println("Introduzca la fecha de ingreso");
	String fechaIngreso = sc.nextLine();
	System.out.println("Introduzca la fecha de salida ");
	String fechaSalida = sc.nextLine();
	System.out.println("Introduzca el motivo ");
	String motivo = sc.nextLine();
	
	AdmisionesController ac = new AdmisionesController();
	List<AdmisionesDTO> listaAdmisiones = ac.buscarAdmision(id, nombreP, habitacion, fechaIngreso, fechaSalida, motivo);
	
	for (AdmisionesDTO admisiones : listaAdmisiones) {
		System.out.println(admisiones.toString());
	}
}
}
