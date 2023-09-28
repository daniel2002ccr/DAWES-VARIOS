import java.util.Scanner;

public class Ejercicio10 {
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Introduce un número: ");
	        int numero = sc.nextInt();
	        sc.close();
	        
	        imprimirFibonacci(numero, 12);

	}
	   public static void imprimirFibonacci(int numero, int iteraccion) {
		   
		   int [] secuencia = new int [iteraccion];
		   
		   secuencia[0] = numero;
		   secuencia[1] = numero;
	   
	   for (int i = 2; i< iteraccion; i++) {
		   secuencia[i] = secuencia[i-1] + secuencia [i-2];
	   }
	   for (int i = 0; i< iteraccion; i++) {
		   System.out.print(secuencia[i] + ", ");
	   }
	   }
}