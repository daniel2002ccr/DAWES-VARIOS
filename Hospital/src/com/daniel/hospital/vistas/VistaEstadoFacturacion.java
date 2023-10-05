package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.EstadoCitasController;
import com.daniel.hospital.controllers.EstadoFacturacionController;
import com.daniel.hospital.dtos.EstadoCitasDTO;
import com.daniel.hospital.dtos.EstadoFacturacionDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaEstadoFacturacion {

	public void menuEstadoFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE ESTADO DE FACTURAS");
			System.out.println("===============================================");
			System.out.println("1. Buscar el estado de una factura");
			System.out.println("2. Insertar el estado de una factura");
			System.out.println("3. Actualizar estado de una factura");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				buscarEstadoFacturacion();
			}

			if (n == 2) {
				menuInsertaEstadoFactura();
			}

			if (n == 3) {
				menuActualizaEstadoFacturacion();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
	}

	public void buscarEstadoFacturacion() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca el id de la factura");
		Integer id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca el estado de la factura; ");
		String estado = sc.nextLine();

		EstadoFacturacionController efc = new EstadoFacturacionController();

		List<EstadoFacturacionDTO> listaEstadoFactura = efc.buscarEstadoFactura(id, estado);

		for (EstadoFacturacionDTO estadoFactura : listaEstadoFactura) {
			System.out.println(estadoFactura.toString());
		}
	}

	public void menuInsertaEstadoFactura() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la factura: ");
		Integer id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la factura ");
		String estado = sc.nextLine();

		EstadoFacturacionController efc = new EstadoFacturacionController();
		efc.CrearEstadoFactura(id, estado);
	}

	public void menuActualizaEstadoFacturacion() throws ClassNotFoundException, SQLException {

		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id de la factura: ");
		Integer id = sc.nextInt();
		sc.nextLine();

		System.out.println("Introduzca por favor el estado de la factura ");
		String estado = sc.nextLine();

		EstadoFacturacionController efc = new EstadoFacturacionController();
		efc.actualizarEstadoFactura(id, estado);
	}
}
