import java.util.Random;

public class Ejercicio9 {

	public static void main(String[] args) {
        int numLanzamientos = 1000000;
        int caras = 0;
        int cruces = 0;

        Random r = new Random();

        for (int i = 0; i < numLanzamientos; i++) {
            int resultado = r.nextInt(2);
            if (resultado == 0) {
                caras++;
            } else {
                cruces++;
            }
        }

        System.out.println("Resultados del lanzamiento de la moneda:");
        System.out.println("Cara: " + caras + " veces");
        System.out.println("Cruz: " + cruces + " veces");
    }
}
