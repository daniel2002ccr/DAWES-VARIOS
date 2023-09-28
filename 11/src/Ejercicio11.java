import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio11 {
	
	class Persona {
	    private String nombre;
	    private int edad;

	    public Persona(String nombre, int edad) {
	        if (nombre != null && !nombre.isEmpty()) {
	            this.nombre = nombre;
	        } else {
	            this.nombre = "Anónimo";
	        }

	        if (edad >= 0) {
	            this.edad = edad;
	        } else {
	            this.edad = 99;
	        }
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }
	

	    public static void main(String[] args) {
	        Ejercicio11 ejercicio11 = new Ejercicio11();  
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<Persona> personas = new ArrayList<>();

	        while (true) {
	            System.out.print("Introduce el nombre de la persona (deja vacío para 'Anónimo'): ");
	            String nombre = scanner.nextLine();

	            System.out.print("Introduce la edad de la persona (ingresa un número válido o negativo para 99): ");
	            int edad = scanner.nextInt();
	            scanner.nextLine();  // 

	            Persona persona = ejercicio11.new Persona(nombre, edad);  
	            personas.add(persona);

	            System.out.print("¿Deseas ingresar otra persona? (s/n): ");
	            String opcion = scanner.nextLine().trim().toLowerCase();

	            if (!opcion.equals("s")) {
	                break;
	            }
	        }

	        System.out.println("Personas ingresadas:");
	        for (Persona persona : personas) {
	            System.out.println("Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
	        }
	    }
	}
}


