package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.Scanner;

import com.daniel.hospital.utils.MiScanner;

public class MenuPrincipal {
	
	
	public void menuPrincipal() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		int n=0;
		do {
	    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE HOSPITAL");
	    System.out.println("===============================================");

        System.out.println("1- Gestión de  Pacientes");
        System.out.println("2- Gestión de Médicos");
        System.out.println("3- Gestión de Citas");
        System.out.println("4- Gestión de Departamentos");
        System.out.println("5- Gestión de Historial Médico");
        System.out.println("6- Gestión de Facturación");
        System.out.println("7- Gestión de Farmacia");
        System.out.println("8- Gestión de Recetas Médicas");
        System.out.println("9- Gestión de Habitaciones");
        System.out.println("10- Gestión de Admisiones");
        System.out.println("11- Gestión de Alergias");
        System.out.println("12- Gestión de Estado de Citas");
        System.out.println("13- Gestión de Estado de Facturación");
        System.out.println("14- Salir");
	    
	  
	    n = Integer.parseInt(sc.nextLine());
	   
	    	
            if (n>14||n<1){
                System.out.print("Elección invalida, inténtalo otra vez...");
                continue;
            }
            if ( n == 1) {
            	VistaPacientes vp = new VistaPacientes();
            	vp.menuPacientes();
            	
            }
            if ( n == 2) {
            	VistaMedicos vm = new VistaMedicos();
            	vm.menuMedicos();
            }
            if ( n == 3) {
            	VistaCitas vc = new VistaCitas();
            	vc.menuCitas();
            }
            if ( n == 4) {
            	VistaDepartamentos vd = new VistaDepartamentos();
            	vd.menuDepartamentos();
            }
            if ( n == 5) {
            	VistaHistorialMedico vhc = new VistaHistorialMedico();
            	vhc.menuHistorialMedico();
            }
            if ( n == 6) {
            	VistaFacturacion vf = new VistaFacturacion();
            	vf.menuFacturas();
            }
            if ( n == 7) {
            	VistaFarmacia vf = new VistaFarmacia();
            	vf.menuFarmacia();
            }
            if ( n == 9) {
            	VistaHabitacion vh = new VistaHabitacion();
            	vh.menuHabitacion();
            }
            
            if ( n == 11) {
            	VistaAlergias vc = new VistaAlergias();
            	vc.menuGeneralAlergias();
            	continue;
            }
            if ( n == 12) {
            	VistaEstadoCitas vec = new VistaEstadoCitas();
            	vec.menuEstadoCitas();
            }
            if ( n == 13) {
            	VistaEstadoFacturacion vef = new VistaEstadoFacturacion();
            	vef.menuEstadoFacturacion();
            }

            if (n == 14) {
            	System.out.println("Saliendo del menú");
            	break;
            }
	    } while(n!=14);
	}

}
