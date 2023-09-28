import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio12 {
	 static class Persona {
	        private String nombre;
	        private int edad;

	        public Persona(String nombre, int edad) {
	            this.nombre = nombre;
	            this.edad = edad;
	        }

	        public String getNombre() {
	            return nombre;
	        }

	        public int getEdad() {
	            return edad;
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Persona> personas = new ArrayList<>();

	        while (true) {
	            System.out.print("Introduce el nombre de la persona (deja vacío para no asignar nombre): ");
	            String nombre = scanner.nextLine();

	            int edad = 0;
	            System.out.print("Introduce la edad de la persona (deja vacío para no asignar edad): ");
	            String edadInput = scanner.nextLine();
	            if (!edadInput.isEmpty()) {
	                try {
	                    edad = Integer.parseInt(edadInput);
	                } catch (NumberFormatException e) {
	                    System.out.println("Edad no válida. No se asignará edad.");
	                }
	            }

	            Persona persona = new Persona(nombre, edad);
	            personas.add(persona);

	            System.out.print("¿Deseas ingresar otra persona? (s/n): ");
	            String opcion = scanner.nextLine().trim().toLowerCase();

	            if (!opcion.equals("s")) {
	                break;
	            }
	        }


	        System.out.println("Personas ingresadas:");
	        for (Persona persona : personas) {
	            System.out.println("Nombre: " + (persona.getNombre() != null ? persona.getNombre() : "No asignado") +
	                    ", Edad: " + (persona.getEdad() > 0 ? persona.getEdad() : "No asignada"));
	        }
	    }
}
