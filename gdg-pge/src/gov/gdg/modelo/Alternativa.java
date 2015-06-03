package gov.gdg.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alternativa
 * 
 */
@Entity
public class Alternativa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAlternativa;

	@Column(columnDefinition = "TEXT")
	private String formulacao;

	@Column
	private boolean certa;

	@Column
	private int pontos;

	@Column
	private int ordem;

	@ManyToOne
	@JoinColumn(name = "idQuestao")
	private Questao questao;

	public Alternativa() {
		super();
		formulacao = "";
		certa = false;
	}

	public Alternativa(Alternativa alternativa, Questao questao) {
		super();
		this.formulacao = alternativa.getFormulacao();
		this.certa = alternativa.isCerta();
		this.pontos = alternativa.getPontos();
		this.ordem = alternativa.getOrdem();
		this.questao = questao;
	}

	public int getIdAlternativa() {
		return idAlternativa;
	}

	public void setIdAlternativa(int idAlternativa) {
		this.idAlternativa = idAlternativa;
	}

	public String getFormulacao() {
		return formulacao;
	}

	public void setFormulacao(String formulacao) {
		this.formulacao = formulacao;
	}

	public boolean isCerta() {
		return certa;
	}

	public void setCerta(boolean certa) {
		this.certa = certa;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

}
