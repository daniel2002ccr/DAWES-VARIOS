package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.DepartamentosController;
import com.daniel.hospital.controllers.FarmaciaController;
import com.daniel.hospital.dtos.DepartamentosDTO;
import com.daniel.hospital.dtos.FarmaciaDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaFarmacia {

	public void menuFarmacia() throws ClassNotFoundException, SQLException  {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE FARMACIAS");
	    System.out.println("===============================================");
	    System.out.println("1. Buscar farmacia");
	    System.out.println("2. Insertar farmacia");
	    System.out.println("3. Actualizar farmacia");
	    System.out.println("4. Volver al menu principal");
	    System.out.println("===============================================");
	    
	    n = Integer.parseInt(sc.nextLine());
	    
	    if (n>4||n<1){
            System.out.print("Elección invalida, inténtalo otra vez...");
            continue;
        }
        if (n == 1) {
        buscarFarmacia();
        }
        
        if ( n== 2) {
        menuInsertaFarmacia();
        }
        
        if (n == 3) {
        menuActualizaFarmacia();
        }
        if (n == 4) {
        MenuPrincipal m = new MenuPrincipal();
        m.menuPrincipal();
        }
        
		} while (n != 4);
}
	
	public void buscarFarmacia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del medicamento: ");
		Integer idFarmacia = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del medicamento: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor la descripcion del medicamento: ");
		String descripcion = sc.nextLine();
		
		System.out.println("Introduzca la cantidad disponible del medicamento: ");
		Integer cantidadDisponible = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca el precio del medicamento: ");
		Float precio = sc.nextFloat();
		sc.nextLine();
		
		FarmaciaController fc = new FarmaciaController();
		List<FarmaciaDTO> listaFarmacia = fc.buscarFarmacia(idFarmacia, nombre, descripcion, cantidadDisponible, precio);
		for (FarmaciaDTO farmacia : listaFarmacia) {
			System.out.println(farmacia.toString());
		}
	}
	public void menuInsertaFarmacia() throws ClassNotFoundException, SQLException {
		
		
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del medicamento: ");
		Integer idFarmacia = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del medicamento: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor la descripcion del medicamento: ");
		String descripcion = sc.nextLine();
		
		System.out.println("Introduzca la cantidad que habrá de medicamentos: ");
		Integer cantidadDisponible = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca el precio del medicamento: ");
		Float precio = sc.nextFloat();
		sc.nextLine();
		
		
		FarmaciaController fc = new FarmaciaController();
		fc.crearFarmacia(idFarmacia, nombre, descripcion, cantidadDisponible, precio);
		
}
public void menuActualizaFarmacia() throws ClassNotFoundException, SQLException {
		
		
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del medicamento: ");
		Integer idFarmacia = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del medicamento: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor la descripcion del medicamento: ");
		String descripcion = sc.nextLine();
		
		System.out.println("Introduzca la cantidad que habrá de medicamentos: ");
		Integer cantidadDisponible = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca el precio del medicamento: ");
		Float precio = sc.nextFloat();
		sc.nextLine();
		
		
		FarmaciaController fc = new FarmaciaController();
		fc.actualizarFarmacia(idFarmacia, nombre, descripcion, cantidadDisponible, precio);
		
}
}
