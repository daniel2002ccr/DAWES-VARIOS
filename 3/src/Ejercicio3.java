import java.util.Random;

public class Ejercicio3 {
	public static void main (String args[]) {
		
		String[] array = {"Daniel","Alvaro", "Lali", "Paula", "Samuel"};
		
		System.out.println("El nombre de mi compañero es " + obtenerNombre(array));
		
		
	}
	public static String obtenerNombre(String[] array) {
		
		Random r = new Random();
		int indice = r.nextInt(array.length);		
		return array[indice];
	}
}
