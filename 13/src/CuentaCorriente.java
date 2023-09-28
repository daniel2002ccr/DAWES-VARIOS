
	public class CuentaCorriente extends Cuenta {

	    public CuentaCorriente(Integer numeroCuenta) {
	        super(0.0, numeroCuenta);
	    }

	    @Override
	    public void retirarDinero(Double cantidad) {
	        setSaldo(getSaldo() - cantidad);
	        System.out.println("Cantidad retirada de la cuenta corriente: " + cantidad);
	    }
	}

	
