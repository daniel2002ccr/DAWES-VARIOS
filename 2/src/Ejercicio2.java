import java.util.Random;

public class Ejercicio2 {
public static void main (String args[]) {
	int numero = generarNumeroAleatorio();
	System.out.println(numero);
}
public static int generarNumeroAleatorio() {
    Random r = new Random();
   
    int numeroAleatorio = r.nextInt(10) + 1;
    return numeroAleatorio;
}
}
