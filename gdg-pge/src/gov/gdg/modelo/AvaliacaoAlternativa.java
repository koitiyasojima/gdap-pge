package gov.gdg.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AvaliacaoAlternativa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long avaliacaoQuestaoId;

	@Column
	private double nota;

	@ManyToOne
	private Questao questao;

	@ManyToOne
	private AvaliacaoUsuario avaliacaoUsuario;

	public AvaliacaoAlternativa() {
		// TODO Auto-generated constructor stub
	}

	public Long getAvaliacaoQuestaoId() {
		return avaliacaoQuestaoId;
	}

	public void setAvaliacaoQuestaoId(Long avaliacaoQuestaoId) {
		this.avaliacaoQuestaoId = avaliacaoQuestaoId;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public AvaliacaoUsuario getAvaliacaoUsuario() {
		return avaliacaoUsuario;
	}

	public void setAvaliacaoUsuario(AvaliacaoUsuario avaliacaoUsuario) {
		this.avaliacaoUsuario = avaliacaoUsuario;
	}

}
