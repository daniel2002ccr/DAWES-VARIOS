import java.util.ArrayList;
import java.util.List;

public class Banco {

    public static void main(String[] args) {
        List<Cuenta> cuentas = new ArrayList<>();

        // Crear cuentas corrientes
        CuentaCorriente cc1 = new CuentaCorriente(1);
        CuentaCorriente cc2 = new CuentaCorriente(2);

        // Crear cuentas de ahorro
        CuentaAhorro ca1 = new CuentaAhorro(101);
        CuentaAhorro ca2 = new CuentaAhorro(102);

        // Agregar cuentas a la lista
        cuentas.add(cc1);
        cuentas.add(cc2);
        cuentas.add(ca1);
        cuentas.add(ca2);

        // Mostrar información inicial de las cuentas
        System.out.println("Información inicial de las cuentas:");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }

        // Retirar dinero de todas las cuentas
        double cantidadARetirar = 50.0;
        System.out.println("\nRetirando " + cantidadARetirar + " de cada cuenta:\n");

        for (Cuenta cuenta : cuentas) {
            cuenta.retirarDinero(cantidadARetirar);
            System.out.println("Nuevo saldo de la cuenta: " + cuenta.getSaldo());
        }
    }
}
