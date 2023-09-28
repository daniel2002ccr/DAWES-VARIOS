import java.util.Scanner;

public class Ejercicio8 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la primera palabra: ");
        String palabra1 = sc.nextLine();

        System.out.print("Ingrese la segunda palabra: ");
        String palabra2 = sc.nextLine();

        if (palabra1.equals(palabra2)) {
            System.out.println("Las palabras son iguales.");
        } else {
            System.out.println("Las palabras son diferentes.");
        }
    }
}
