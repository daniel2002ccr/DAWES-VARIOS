	import java.util.Random;
public class Ejercicio4 {
	    public enum Nombres {
	        ALVARO, FRANCISCO, LALI, PAULA, DANIEL
	    }

	    public static void main(String[] args) {
	        Nombres[] array = Nombres.values();
	        Nombres nombreAleatorio = obtenerNombreAleatorio(array);

	        System.out.println("El nombre de mi compañero es " + obtenerNombreAleatorio(array));
			}

	    public static Nombres obtenerNombreAleatorio(Nombres[] nombres) {
	        Random r = new Random();
	        int indiceAleatorio = r.nextInt(nombres.length);
	        return nombres[indiceAleatorio];
	    }
	}
