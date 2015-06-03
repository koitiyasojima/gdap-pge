package gov.gdg.modelo.tipos;

public enum TipoAvaliacao {
	DT("Dimens�o T�cnica"), DP("Dimens�o Pessoal");

	private final String nome;

	private TipoAvaliacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
