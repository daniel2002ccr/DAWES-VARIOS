package com.daniel.hospital.vistas;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.daniel.hospital.controllers.AlergiasController;
import com.daniel.hospital.dtos.AlergiaDTO;
import com.daniel.hospital.utils.MiScanner;


public class VistaAlergias {
	
	public void menuGeneralAlergias() throws ClassNotFoundException, SQLException {
	
			Scanner sc = MiScanner.getInstance();
			int n=0;
			do{
				System.out.println("Introduzca la operación que desee realizar: ");
				
			    System.out.println("       MENÚ PRINCIPAL PARA LA GESTIÓN DE LA TABLA ALERGIAS");
			    System.out.println("===========================================================");
			    System.out.println("1. Buscar alergia");
			    System.out.println("2. Insertar alergia");
			    System.out.println("3. Actualizar alergia ");
			    System.out.println("4. Volver al menú principal");
			    System.out.println("===============================================");
			    
			    n = Integer.parseInt(sc.nextLine());
		    
	            if (n == 4){
	                
	                return;
	            }
		    	
	            if (n>4||n<1){
	                System.out.print("Elección inválida, inténtalo otra vez...");
	                continue;
	            }
	            if ( n == 1) {
	            	menuBuscaAlergia();
	            	continue;
	            }
	            
	            if ( n == 2) {
	            	menuInsertaAlergia();
	            	continue;
	            }
	            
	            if ( n == 3) {
	            	menuActualizarAlergia();
	            	continue;
	            }
		    	
		    } while(n!=4);
		
	}

	
	public void menuBuscaAlergia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		System.out.println("Introduzca por favor el id de la alergia: ");
		String id = sc.nextLine();
	
		System.out.println("Introduzca por favor el nombre de la alergia: ");
		String nombreAlergia = sc.nextLine();
		
		AlergiasController controladorAlergias = new AlergiasController();
		List <AlergiaDTO> listaAlergia = controladorAlergias.buscarAlergias(id, nombreAlergia);
		
		for (AlergiaDTO alergia : listaAlergia) {
			System.out.println(alergia.getId() + " " + alergia.getDescripcion());

		}
		
	}
	

	
	public void menuInsertaAlergia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		

		System.out.println("Introduzca por favor el nombre de la alergia: ");
		String nombreAlergia = sc.nextLine();		


		
		AlergiasController controladorAlergias = new AlergiasController();
		int resultado = controladorAlergias.insertarAlergia(nombreAlergia);
		if (resultado == 1) {
			System.out.println("Se ha introducido el registro con éxito");
		} else {
			System.out.println("Se ha producido un error al introducir el registro");
		}
	
	}
	
	public void menuActualizarAlergia() throws ClassNotFoundException, SQLException {
		Scanner sc = MiScanner.getInstance();
		
		System.out.println("Introduzca por favor el ID de alergia a actualizar: ");
		int  id = Integer.parseInt(sc.nextLine());		
		System.out.println("Introduzca por favor el nuevo nombre de la alergia: ");
		String nombreAlergia = sc.nextLine();		

		
		AlergiasController controladorAlergias = new AlergiasController();
		int resultado = controladorAlergias.actualizarAlergia(id, nombreAlergia);
		if (resultado == 1) {
			System.out.println("Se ha actualizado el alergia con el número: " + id +" con éxito");
		} else {
			System.out.println("Se ha producido un error al actualizar el alergia con el número: "+ id);
		}
		
	}

}
