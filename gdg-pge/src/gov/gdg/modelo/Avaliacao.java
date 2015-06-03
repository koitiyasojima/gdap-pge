package gov.gdg.modelo;

import gov.gdg.modelo.tipos.TipoAvaliacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Avaliacao
 * 
 */
@Entity
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAvaliacao;

	@Column
	private String nome;

	@Column
	private TipoAvaliacao tipoAvaliacao;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Temporal(TemporalType.DATE)
	@Column
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	@Column
	private Date dataFim;

	@Column
	private boolean emVigor;

	@OneToMany(mappedBy = "avaliacao", cascade = { CascadeType.ALL })
	@OrderBy(value = "ordem")
	private List<Questao> questoes;

	public Avaliacao() {
		super();
		nome = "";
		descricao = "";
		emVigor = false;
		tipoAvaliacao = TipoAvaliacao.DP;
		questoes = new ArrayList<Questao>();
	}

	public Avaliacao(Avaliacao avaliacao) {
		super();

		nome = avaliacao.getNome();
		descricao = avaliacao.getDescricao();
		tipoAvaliacao = avaliacao.getTipoAvaliacao();
		dataInicio = avaliacao.getDataInicio();
		dataFim = avaliacao.getDataFim();
		emVigor = avaliacao.isEmVigor();

		questoes = new ArrayList<Questao>();
		for (Questao questao : avaliacao.getQuestoes()) {
			questoes.add(new Questao(questao, this));
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public boolean isEmVigor() {
		return emVigor;
	}

	public void setEmVigor(boolean emVigor) {
		this.emVigor = emVigor;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

}
