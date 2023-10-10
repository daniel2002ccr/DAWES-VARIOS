package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.Scanner;

import com.daniel.hospital.controllers.CitasController;
import com.daniel.hospital.utils.MiScanner;

public class VistaCitas {

	public void menuCitas() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE CITAS");
			System.out.println("===============================================");
			System.out.println("1. Buscar cita");
			System.out.println("2. Insertar cita");
			System.out.println("3. Actualizar cita");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
//				buscarPaciente();
			}

			if (n == 2) {
				crearCita();
			}

			if (n == 3) {
				actualizarCita();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
}
public void crearCita() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre del paciente");
		String nombreP = sc.nextLine();
		System.out.println("Introduzca el nombre del medico ");
		String nombreM = sc.nextLine();
		System.out.println("Introduzca la fecha ");
		String fecha = sc.nextLine();
		System.out.println("Introduzca la hora ");
		String hora = sc.nextLine();
		System.out.println("Introduzca el estado ");
		String estado = sc.nextLine();
		
		CitasController cc = new CitasController();
		cc.crearCita(nombreP, nombreM, fecha, hora, estado);
		
}
public void actualizarCita() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca el id de la cita");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca el nombre del medico ");
	String nombreM = sc.nextLine();
	System.out.println("Introduzca la fecha ");
	String fecha = sc.nextLine();
	System.out.println("Introduzca la hora ");
	String hora = sc.nextLine();
	System.out.println("Introduzca el estado ");
	String estado = sc.nextLine();
	
	CitasController cc = new CitasController();
	cc.actualizarCita(id, nombreP, nombreM, fecha, hora, estado);
	
}
}
