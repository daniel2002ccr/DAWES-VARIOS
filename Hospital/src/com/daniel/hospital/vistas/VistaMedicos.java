package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.MedicosController;
import com.daniel.hospital.dtos.MedicosDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaMedicos {
	public void menuMedicos() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE MEDICOS");
			System.out.println("===============================================");
			System.out.println("1. Buscar medico");
			System.out.println("2. Insertar medico");
			System.out.println("3. Actualizar medico");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				recuperaMedico();
			}

			if (n == 2) {
				creaMedico();
			}

			if (n == 3) {
				actualizaMedico();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
	}

	public void recuperaMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca el id del medico");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca el nombre del medico");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido del medico");
		String apellido = sc.nextLine();
		System.out.println("Introduzca la especialidad del medico");
		String especialidad = sc.nextLine();
		System.out.println("Introduzca la licencia del medico");
		String licencia = sc.nextLine();
		System.out.println("Introduzca el telefono del medico");
		String telefono = sc.nextLine();
		System.out.println("Introduzca el correo electronico del medico");
		String correo = sc.nextLine();

		MedicosController mc = new MedicosController();
		List<MedicosDTO> listaMedicos = mc.buscarMedico(id, nombre, apellido, especialidad, licencia, telefono, correo);
		for (MedicosDTO medico : listaMedicos) {
			System.out.println(medico.toString());
		}
	}

	public void creaMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca el nombre del medico");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido del medico");
		String apellido = sc.nextLine();
		System.out.println("Introduzca la especialidad del medico");
		String especialidad = sc.nextLine();
		System.out.println("Introduzca la licencia del medico");
		String licencia = sc.nextLine();
		System.out.println("Introduzca el telefono del medico");
		String telefono = sc.nextLine();
		System.out.println("Introduzca el correo electronico del medico");
		String correo = sc.nextLine();

		MedicosController mc = new MedicosController();
		mc.crearMedico(nombre, apellido, especialidad, licencia, telefono, correo);
	}

	public void actualizaMedico() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca el id del medico");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca el nombre del medico");
		String nombre = sc.nextLine();
		System.out.println("Introduzca el apellido del medico");
		String apellido = sc.nextLine();
		System.out.println("Introduzca la especialidad del medico");
		String especialidad = sc.nextLine();
		System.out.println("Introduzca la licencia del medico");
		String licencia = sc.nextLine();
		System.out.println("Introduzca el telefono del medico");
		String telefono = sc.nextLine();
		System.out.println("Introduzca el correo electronico del medico");
		String correo = sc.nextLine();

		MedicosController mc = new MedicosController();
		mc.actualizarHabitacion(id, nombre, apellido, especialidad, licencia, telefono, correo);
	}
}
