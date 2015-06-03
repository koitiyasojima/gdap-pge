package gov.gdg.modelo.tipos;

public enum TipoPeso {
	FUNDAMENTAL(3), MEDIO(4), SUPERIOR(11);

	private final int peso;

	private TipoPeso(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}
}
