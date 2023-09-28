
public class Cuenta {

	private Double saldo; // Saldo actual
	private Integer numeroCuenta; // Número de cuenta
	
	

	public Cuenta(Double saldo, Integer numeroCuenta) {
		super();
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Cuenta(Integer a, Double saldo) {
		saldo = 0.0;
		numeroCuenta = a;
	}

	public void ingresarDinero(Double sum) {
		if (sum > 0)
			saldo += sum;
		else
			System.err.println("No se puede ingresar una cantidad negativa");
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", numeroCuenta=" + numeroCuenta + "]";
	}
}
