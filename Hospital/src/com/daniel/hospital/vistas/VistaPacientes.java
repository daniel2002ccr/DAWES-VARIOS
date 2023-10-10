package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.EstadoCitasController;
import com.daniel.hospital.controllers.PacientesController;
import com.daniel.hospital.dtos.EstadoCitasDTO;
import com.daniel.hospital.dtos.PacientesDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaPacientes {
	public void menuPacientes() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE PACIENTES");
			System.out.println("===============================================");
			System.out.println("1. Buscar paciente");
			System.out.println("2. Insertar paciente");
			System.out.println("3. Actualizar paciente");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				buscarPaciente();
			}

			if (n == 2) {
				crearPaciente();
			}

			if (n == 3) {
				actualizarPaciente();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
	}
	public void buscarPaciente() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca el id del paciente");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca el nombre ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido ");
		String apellido = sc.nextLine();
		System.out.println("Introduzca la fecha de nacimiento ");
		String fechaNac = sc.nextLine();
		System.out.println("Introduzca el dni ");
		String dni = sc.nextLine();
		System.out.println("Introduzca la direccion ");
		String direccion = sc.nextLine();
		System.out.println("Introduzca el telefono ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca el correo electronico ");
		String correoElectronico = sc.nextLine();
		System.out.println("Introduzca la alergia");
		String alergia = sc.nextLine();
		System.out.println("Introduzca el historial medico");
		String historial = sc.nextLine();
		

		PacientesController pc = new PacientesController();

		List<PacientesDTO> listaPacientes = pc.buscarPacientes(id, nombre, apellido, fechaNac, dni, direccion, telefono, correoElectronico, alergia, historial);

		for (PacientesDTO estadoPacientes : listaPacientes) {
			System.out.println(estadoPacientes.toString());
		}
	}
	public void crearPaciente() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el id del paciente");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca el nombre ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido ");
		String apellido = sc.nextLine();
		System.out.println("Introduzca la fecha de nacimiento ");
		String fechaNac = sc.nextLine();
		System.out.println("Introduzca el dni ");
		String dni = sc.nextLine();
		System.out.println("Introduzca la direccion ");
		String direccion = sc.nextLine();
		System.out.println("Introduzca el telefono ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca el correo electronico ");
		String correoElectronico = sc.nextLine();
		System.out.println("Introduzca la alergia");
		String alergia = sc.nextLine();
		
		System.out.println("Introduzca el historial medico");
		String historial = sc.nextLine();
		
		PacientesController pc = new PacientesController();
		pc.creaPaciente(id, nombre, apellido, fechaNac, dni, direccion, telefono, correoElectronico, alergia, historial);
	}
	
	public void actualizarPaciente() throws ClassNotFoundException, SQLException {
	Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el id del paciente");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca el nombre ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido ");
		String apellido = sc.nextLine();
		System.out.println("Introduzca la fecha de nacimiento ");
		String fechaNac = sc.nextLine();
		System.out.println("Introduzca el dni ");
		String dni = sc.nextLine();
		System.out.println("Introduzca la direccion ");
		String direccion = sc.nextLine();
		System.out.println("Introduzca el telefono ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca el correo electronico ");
		String correoElectronico = sc.nextLine();
		System.out.println("Introduzca la alergia");
		String alergia = sc.nextLine();
		System.out.println("Introduzca el historial medico");
		String historial = sc.nextLine();
		
		PacientesController pc = new PacientesController();
		pc.actualizaPaciente(id, nombre, apellido, fechaNac, dni, direccion, telefono, correoElectronico, alergia, historial);
	}
}
