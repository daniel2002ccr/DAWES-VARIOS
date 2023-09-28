
	public class CuentaAhorro extends Cuenta {

	    public CuentaAhorro(Integer numeroCuenta) {
	        super(0.0, numeroCuenta);
	    }

	    @Override
	    public void retirarDinero(Double cantidad) {
	        if (getSaldo() - cantidad >= 0) {
	            setSaldo(getSaldo() - cantidad);
	            System.out.println("Cantidad retirada de la cuenta de ahorro: " + cantidad);
	        } else {
	            System.err.println("No se puede retirar una cantidad mayor al saldo en la cuenta de ahorro.");
	        }
	    }
	}
