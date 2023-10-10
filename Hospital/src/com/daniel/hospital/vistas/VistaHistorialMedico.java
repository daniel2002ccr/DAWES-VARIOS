package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.Scanner;

import com.daniel.hospital.controllers.CitasController;
import com.daniel.hospital.controllers.HistorialMedicoController;
import com.daniel.hospital.utils.MiScanner;

public class VistaHistorialMedico {

	public void menuHistorialMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE HISTORIAL MEDICO");
			System.out.println("===============================================");
			System.out.println("1. Buscar historial");
			System.out.println("2. Insertar historial nuevo");
			System.out.println("3. Actualizar historial");
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
				crearHistorial();
			}

			if (n == 3) {
				actualizarHistorial();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
}
public void crearHistorial() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre del paciente");
		String nombreP = sc.nextLine();
		System.out.println("Introduzca el nombre del medico ");
		String nombreM = sc.nextLine();
		System.out.println("Introduzca la fecha ");
		String fecha = sc.nextLine();
		System.out.println("Introduzca el diagnostico ");
		String hora = sc.nextLine();
		System.out.println("Introduzca el tratamiento ");
		String estado = sc.nextLine();
		

		HistorialMedicoController hmc = new HistorialMedicoController();
		hmc.crearHistorial(nombreP, nombreM, fecha, hora, estado);
}

public void actualizarHistorial() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca el id del historial");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca el nombre del medico ");
	String nombreM = sc.nextLine();
	System.out.println("Introduzca la fecha ");
	String fecha = sc.nextLine();
	System.out.println("Introduzca el diagnostico ");
	String diagnostico = sc.nextLine();
	System.out.println("Introduzca el tratamiento ");
	String tratamiento = sc.nextLine();
	
	HistorialMedicoController hmc = new HistorialMedicoController();
	hmc.actualizarHistorial(id, nombreP, nombreM, fecha, diagnostico, tratamiento);
	
}
}
