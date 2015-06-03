package gov.gdg.modelo.tipos;

public enum TipoCargo {
	SECRETARIA("Secret�ria", 4), DIRETOR("Diretor", 3), COORDENADOR(
			"Coordenador", 2), SERVIDOR("Servidor", 1);

	private final String nome;
	private final int nivel;

	private TipoCargo(String nome, int nivel) {
		this.nome = nome;
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}
	
	public int getNivel() {
		return nivel;
	}
}
