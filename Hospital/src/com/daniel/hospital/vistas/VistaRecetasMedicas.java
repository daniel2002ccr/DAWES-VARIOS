package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.RecetasMedicasController;
import com.daniel.hospital.dtos.RecetasMedicasDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaRecetasMedicas {

	public void menuRecetas() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n = 0;
		do {
			System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE RECETAS");
			System.out.println("===============================================");
			System.out.println("1. Buscar receta medica");
			System.out.println("2. Insertar receta medica");
			System.out.println("3. Actualizar receta medica");
			System.out.println("4. Volver al menu principal");
			System.out.println("===============================================");

			n = Integer.parseInt(sc.nextLine());

			if (n > 4 || n < 1) {
				System.out.print("Elección invalida, inténtalo otra vez...");
				continue;
			}
			if (n == 1) {
				buscarReceta();
			}

			if (n == 2) {
				crearReceta();
			}

			if (n == 3) {
				actualizarReceta();
			}
			if (n == 4) {
				MenuPrincipal m = new MenuPrincipal();
				m.menuPrincipal();
			}
		} while (n != 4);
}
	
public void crearReceta() throws ClassNotFoundException, SQLException {
		
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca el nombre del paciente");
		String nombreP = sc.nextLine();
		System.out.println("Introduzca el nombre del medico ");
		String nombreM = sc.nextLine();
		System.out.println("Introduzca el nombre del medicamento ");
		String nombreMedicamento = sc.nextLine();
		System.out.println("Introduzca la fecha ");
		String fecha = sc.nextLine();
		System.out.println("Introduzca la cantidad prestada ");
		int cantidad = sc.nextInt();
		sc.nextLine();
		
		RecetasMedicasController rmc = new RecetasMedicasController();
		rmc.crearReceta(nombreP, nombreM, nombreMedicamento, fecha, cantidad);
}

public void actualizarReceta() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	
	System.out.println("Introduzca el id de la receta");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca el nombre del medico ");
	String nombreM = sc.nextLine();
	System.out.println("Introduzca el nombre del medicamento ");
	String nombreMedicamento = sc.nextLine();
	System.out.println("Introduzca la fecha ");
	String fecha = sc.nextLine();
	System.out.println("Introduzca la cantidad prestada ");
	int cantidad = sc.nextInt();
	sc.nextLine();
	
	RecetasMedicasController rmc = new RecetasMedicasController();
	rmc.actualizaRecetaMedica(id, nombreP, nombreM, nombreMedicamento, fecha, cantidad);
}

public void buscarReceta() throws ClassNotFoundException, SQLException {
	
	Scanner sc = MiScanner.getInstance();
	
	System.out.println("Introduzca el id de la receta");
	int id = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduzca el nombre del paciente");
	String nombreP = sc.nextLine();
	System.out.println("Introduzca el nombre del medico ");
	String nombreM = sc.nextLine();
	System.out.println("Introduzca el nombre del medicamento ");
	String nombreMedicamento = sc.nextLine();
	System.out.println("Introduzca la fecha ");
	String fecha = sc.nextLine();
	System.out.println("Introduzca la cantidad prestada ");
	int cantidad = sc.nextInt();
	sc.nextLine();
	
	RecetasMedicasController rmc = new RecetasMedicasController();
	List <RecetasMedicasDTO> listaRecetas = rmc.buscarReceta(id, nombreP, nombreM, nombreMedicamento, fecha, cantidad);
	
	for (RecetasMedicasDTO recetas : listaRecetas) {
		System.out.println(recetas.toString());
	}
}
}
