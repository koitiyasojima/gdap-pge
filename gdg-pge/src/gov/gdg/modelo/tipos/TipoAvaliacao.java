package gov.gdg.modelo.tipos;

public enum TipoAvaliacao {
	DT("Dimensão Técnica"), DP("Dimensão Pessoal");

	private final String nome;

	private TipoAvaliacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
