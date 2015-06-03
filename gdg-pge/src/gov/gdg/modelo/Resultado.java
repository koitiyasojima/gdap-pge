package gov.gdg.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Resultado
 * 
 */
@Entity
public class Resultado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idResultado;

	@Column
	private String nome;

	@ManyToOne
	@JoinColumn(referencedColumnName = "idAvaliacao")
	private Avaliacao avaliacaoDP;

	@ManyToOne
	@JoinColumn(referencedColumnName = "idAvaliacao")
	private Avaliacao avaliacaoDT;

	@OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL)
	private Set<Meta> metas;

	@Column
	private boolean visivel;

	public Resultado() {
		super();
		nome = "";
		metas = new HashSet<Meta>();
	}

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Avaliacao getAvaliacaoDP() {
		return avaliacaoDP;
	}

	public void setAvaliacaoDP(Avaliacao avaliacaoDP) {
		this.avaliacaoDP = avaliacaoDP;
	}

	public Avaliacao getAvaliacaoDT() {
		return avaliacaoDT;
	}

	public void setAvaliacaoDT(Avaliacao avaliacaoDT) {
		this.avaliacaoDT = avaliacaoDT;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public Set<Meta> getMetas() {
		return metas;
	}

	public void setMetas(Set<Meta> metas) {
		this.metas = metas;
	}

}
