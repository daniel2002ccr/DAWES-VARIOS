package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.DepartamentosController;
import com.daniel.hospital.controllers.HabitacionesController;
import com.daniel.hospital.dtos.DepartamentosDTO;
import com.daniel.hospital.dtos.HabitacionDTO;
import com.daniel.hospital.utils.MiScanner;

public class VistaDepartamentos {

	public void menuDepartamentos() throws ClassNotFoundException, SQLException  {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("MENÚ PRINCIPAL PARA LA GESTIÓN DE DEPARTAMENTOS");
	    System.out.println("===============================================");
	    System.out.println("1. Buscar departamentos");
	    System.out.println("2. Insertar departamento");
	    System.out.println("3. Actualizar departamento");
	    System.out.println("4. Eliminar departamento");
	    System.out.println("5. Volver al menu principal");
	    System.out.println("===============================================");
	    
	    n = Integer.parseInt(sc.nextLine());
	    
	    if (n>4||n<1){
            System.out.print("Elección invalida, inténtalo otra vez...");
            continue;
        }
        if (n == 1) {
        buscarDepartamento();
        }
        
        if ( n== 2) {
        menuInsertaDepartamento();
        }
        
        if (n == 3) {
        menuActualizarDepartamento();
        }
        if (n == 4) {
        menuBorrarDepartamento();
            }
        if (n == 5) {
        MenuPrincipal m = new MenuPrincipal();
        m.menuPrincipal();
        }
    
    
	} while (n != 4);
}
	public void buscarDepartamento() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del departamento: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca por favor el nombre del departamento: ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca por favor la descripcion del departamento: ");
		String descripcion = sc.nextLine();
		System.out.println("Introduzca si está activo ");
		Integer activo = sc.nextInt();
		sc.nextLine();
		DepartamentosController dc = new DepartamentosController();
		List<DepartamentosDTO> listaDepartamentos = dc.buscarDepartamentos(id, nombre, descripcion, activo);
	
		for (DepartamentosDTO departamentos : listaDepartamentos) {
			System.out.println(departamentos.toString());
		}
	}
	public void menuInsertaDepartamento() throws ClassNotFoundException, SQLException {
		
		
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del departamento: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del departamento: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor la descripcion del departamento: ");
		String descripcion = sc.nextLine();
		
		System.out.println("Introduzca si está activo: ");
		Integer activo = sc.nextInt();
		sc.nextLine();
		
		
		DepartamentosController dc = new DepartamentosController();
		dc.crearDepartamento(id, nombre, descripcion, activo);
}
public void menuActualizarDepartamento() throws ClassNotFoundException, SQLException {
		
		
		Scanner sc = MiScanner.getInstance();

		System.out.println("Introduzca por favor el id del departamento: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Introduzca por favor el nombre del departamento: ");
		String nombre = sc.nextLine();
		
		System.out.println("Introduzca por favor la descripcion del departamento: ");
		String descripcion = sc.nextLine();
		
		System.out.println("Introduzca si está activo (debe introducir obligatoriamente 0 o 1): ");
		Integer activo = sc.nextInt();
		sc.nextLine();
		
		
		DepartamentosController dc = new DepartamentosController();
		dc.actualizarDepartamentos(id, nombre, descripcion, activo);
}
public void menuBorrarDepartamento() throws ClassNotFoundException, SQLException {
	Scanner sc = MiScanner.getInstance();
	System.out.println("Introduzca por favor el id del departamento: ");
	Integer id = sc.nextInt();
	sc.nextLine();
	
	DepartamentosController dc = new DepartamentosController();
	dc.borrarDepartamentos(id, 0);
}
}
