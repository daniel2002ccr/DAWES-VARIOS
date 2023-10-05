package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.DepartamentosController;
import com.daniel.hospital.controllers.EstadoCitasController;
import com.daniel.hospital.dtos.EstadoCitasDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaEstadoCitas {

	public void menuEstadoCitas() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE ESTADO CITAS");
			System.out.println("===============================================");
			System.out.println("1. Buscar el estado de una cita");
			System.out.println("2. Insertar el estado de una cita");
			System.out.println("3. Actualizar estado de una cita");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				buscarEstadoCita();
			}

			if (n == 2) {
				menuInsertaEstadoCitas();
			}

			if (n == 3) {
				menuActualizaEstadoCitas();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
	}

	public void buscarEstadoCita() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca el id de la cita");
		Integer id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca el estado de la cita; ");
		String estado = sc.nextLine();

		EstadoCitasController ecc = new EstadoCitasController();

		List<EstadoCitasDTO> listaEstadoCitas = ecc.buscarEstadoCita(id, estado);

		for (EstadoCitasDTO estadoCitas : listaEstadoCitas) {
			System.out.println(estadoCitas.toString());
		}
	}

	public void menuInsertaEstadoCitas() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la cita: ");
		Integer id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita ");
		String estado = sc.nextLine();

		EstadoCitasController ecc = new EstadoCitasController();
		ecc.CrearEstadoCitas(id, estado);
	}

	public void menuActualizaEstadoCitas() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la cita: ");
		Integer id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la cita ");
		String estado = sc.nextLine();

		EstadoCitasController ecc = new EstadoCitasController();
		ecc.actualizarEstadoCitas(id, estado);
	}
}
