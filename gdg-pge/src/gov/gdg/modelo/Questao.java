package gov.gdg.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Questao
 * 
 */
@Entity
public class Questao implements Serializable, Comparable<Questao> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idQuestao;

	@Column
	private String formulacao;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Column
	private int ordem;

	@ManyToOne
	@JoinColumn(name = "idAvaliacao")
	private Avaliacao avaliacao;

	@OneToMany(mappedBy = "questao", cascade = { CascadeType.ALL })
	@OrderBy(value = "ordem")
	private List<Alternativa> alternativas;

	@Transient
	private Alternativa alternativaSelecionada;

	public Questao() {
		super();
		formulacao = "";
		descricao = "";
		alternativas = new LinkedList<Alternativa>();
	}

	public Questao(Questao questao, Avaliacao avaliacao) {
		super();

		this.formulacao = questao.getFormulacao();
		this.descricao = questao.getDescricao();
		this.ordem = questao.getOrdem();
		this.avaliacao = avaliacao;
		this.alternativas = new ArrayList<Alternativa>();

		for (Alternativa alternativa : questao.getAlternativas()) {
			alternativas.add(new Alternativa(alternativa, this));
		}
	}

	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getFormulacao() {
		return formulacao;
	}

	public void setFormulacao(String formulacao) {
		this.formulacao = formulacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public void setAlternativaSelecionada(Alternativa alternativaSelecionada) {
		this.alternativaSelecionada = alternativaSelecionada;
	}

	public Alternativa getAlternativaSelecionada() {
		return alternativaSelecionada;
	}

	@Override
	public int compareTo(Questao o) {
		if (this.ordem > o.getOrdem()) {
			return 1;
		} else {
			return -1;
		}
	}

}
