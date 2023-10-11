package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.FacturacionController;
import com.daniel.hospital.dtos.FacturacionDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaFacturacion {

	public void menuFacturas() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE FACTURACION");
			System.out.println("===============================================");
			System.out.println("1. Buscar factura");
			System.out.println("2. Insertar factura");
			System.out.println("3. Actualizar factura");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				buscarFacturacion();
			}

			if (n == 2) {
				crearFacturacion();
			}

			if (n == 3) {
				actualizaFacturacion();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
}
public void crearFacturacion() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre del paciente");
		String nombreP = sc.nextLine();
		System.out.println("Introduzca la fecha ");
		String fecha = sc.nextLine();
		System.out.println("Introduzca el monto ");
		Float monto = sc.nextFloat();
		sc.nextLine();
		System.out.println("Introduzca el estado ");
		String estado = sc.nextLine();
		
		FacturacionController fc = new FacturacionController();
		fc.crearFacturacion(nombreP, fecha, monto, estado);
}

public void actualizaFacturacion() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca el id de la factura");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca la fecha ");
	String fecha = sc.nextLine();
	System.out.println("Introduzca el monto ");
	Float monto = sc.nextFloat();
	sc.nextLine();
	System.out.println("Introduzca el estado ");
	String estado = sc.nextLine();
	
	FacturacionController fc = new FacturacionController();
	fc.actualizaFacturacion(id, nombreP, fecha, monto, estado);
}
public void buscarFacturacion() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();

	System.out.println("Introduzca el id de la factura");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca la fecha ");
	String fecha = sc.nextLine();
	System.out.println("Introduzca el monto ");
	Float monto = sc.nextFloat();
	sc.nextLine();
	System.out.println("Introduzca el estado ");
	String estado = sc.nextLine();
	
	FacturacionController fc = new FacturacionController();
	List<FacturacionDTO> listaFactura = fc.buscarFacturacion(id, nombreP, fecha, monto, estado);
	
	for (FacturacionDTO factura : listaFactura) {
		System.out.println(factura.toString());
	}
}
}
