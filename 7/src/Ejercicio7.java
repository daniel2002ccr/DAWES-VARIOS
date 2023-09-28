
public class Ejercicio7 {

	    public static void main(String[] args) {

	        for (int i = 2; i <= 100; i++) {
	            if (esPrimo(i)) {
	                System.out.print(i + " ");
	            }
	        }
	    }


	    public static boolean esPrimo(int num) {
	        if (num < 2) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(num); i++) {
	            if (num % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}

