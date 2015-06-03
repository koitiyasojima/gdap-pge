package gov.gdg.modelo.tipos;


import com.vaadin.data.util.BeanItemContainer;

public enum TipoGrupo {
	
	NORMAL("Normal","Modo de avaliação normal, Maiores avaliam menores, e menores avaliam maiores e do mesmo nível"),
	ESPECIAL("Top-Down","Níveis maiores avaliam menores, mas os menores nao avaliam ninguem"),
	ESPECIAL2("Top-Down-Up","Níveis maiores avaliam menores, menores avaliam apenas os superiores");
	
	
	private String nome;
	private String descricao;
		
	private TipoGrupo(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static BeanItemContainer<TipoGrupo> getContainer() {
		BeanItemContainer<TipoGrupo> container = new BeanItemContainer<TipoGrupo>(
				TipoGrupo.class);

		for (TipoGrupo grupo : values()) {
			container.addBean(grupo);
		}

		return container;
	}
	
}
