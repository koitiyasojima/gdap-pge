package gov.gdg.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: AvaliacaoUsuario
 * 
 */
@Entity
public class AvaliacaoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAvaliacaoUsuario;

	@ManyToOne
	@JoinColumn(referencedColumnName = "idUsuario", nullable = false)
	private Usuario avaliador;

	@ManyToOne
	@JoinColumn(referencedColumnName = "idUsuario", nullable = false)
	private Usuario avaliado;

	@ManyToOne
	@JoinColumn(referencedColumnName = "idAvaliacao", nullable = false)
	private Avaliacao avaliacao;

	@Column
	@Temporal(value = TemporalType.DATE)
	private Date dataAvaliacao;

	@Column
	private float nota;

	@Column
	private boolean finalizado;

	@OneToMany(mappedBy = "avaliacaoUsuario", cascade = { CascadeType.REMOVE })
	private List<AvaliacaoAlternativa> avaliacaoAlternativaList;

	public AvaliacaoUsuario() {
		super();
		finalizado = false;
		dataAvaliacao = new Date();
	}

	public int getIdAvaliacaoUsuario() {
		return idAvaliacaoUsuario;
	}

	public void setIdAvaliacaoUsuario(int idAvaliacaoUsuario) {
		this.idAvaliacaoUsuario = idAvaliacaoUsuario;
	}

	public Usuario getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Usuario avaliador) {
		this.avaliador = avaliador;
	}

	public Usuario getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(Usuario avaliado) {
		this.avaliado = avaliado;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public List<AvaliacaoAlternativa> getAvaliacaoAlternativaList() {
		return avaliacaoAlternativaList;
	}

	public void setAvaliacaoAlternativaList(
			List<AvaliacaoAlternativa> avaliacaoAlternativaList) {
		this.avaliacaoAlternativaList = avaliacaoAlternativaList;
	}

}
