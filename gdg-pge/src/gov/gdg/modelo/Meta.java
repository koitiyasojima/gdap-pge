package gov.gdg.modelo;

import gov.gdg.modelo.tipos.TipoMeta;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Meta
 * 
 */
@Entity
public class Meta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMeta;

	@Column
	private String meta;

	@Column(columnDefinition = "TEXT")
	private String observacao;

	@Column
	private TipoMeta nota;

	@Column
	private boolean finalizado;

	@ManyToOne
	private Diretoria diretoria;

	@ManyToOne(cascade = CascadeType.ALL)
	private Resultado resultado;

	public Meta() {
		super();
		this.finalizado = false;
	}

	public int getIdMeta() {
		return idMeta;
	}

	public void setIdMeta(int idMeta) {
		this.idMeta = idMeta;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public TipoMeta getNota() {
		return nota;
	}

	public void setNota(TipoMeta nota) {
		this.nota = nota;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Diretoria getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(Diretoria diretoria) {
		this.diretoria = diretoria;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
