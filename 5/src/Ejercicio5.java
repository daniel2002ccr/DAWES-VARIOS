import java.util.Random;

public class Ejercicio5 {

    public static void main(String args[]) {
        int numero = generarNumero();
        for (int i = 0; i < 20; i++) {
            int numeroGenerado = generarNumero();  
            if (numero > numeroGenerado) {
                System.out.println("El primer número " + numero + " es mayor que " + numeroGenerado);
            } else if (numero < numeroGenerado) {
                System.out.println("El primer número " + numero + " es menor que " + numeroGenerado);
            } else {
                System.out.println("El primer número " + numero + " es igual que " + numeroGenerado);
            }
        }
    }

    public static int generarNumero() {
        Random r = new Random();
        int numero = r.nextInt(20);
        return numero;
    }
}

