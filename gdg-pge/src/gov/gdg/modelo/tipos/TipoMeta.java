package gov.gdg.modelo.tipos;

public enum TipoMeta {
	NAO_ATENDE("Não Atende", 10), ATENDE_PARCIALMENTE("Atende Parcialmente", 30), ATENDE_TOTALMENTE(
			"Atende Totalmente", 60);

	private final String nome;
	private final int nota;

	private TipoMeta(String nome, int nota) {
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public int getNota() {
		return nota;
	}
}
