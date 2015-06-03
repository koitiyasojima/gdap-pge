package gov.gdg.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Diretoria
 * 
 */
@Entity
public class Diretoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDiretoria;

	@Column(unique = true)
	private String nome;

	@OneToMany(mappedBy = "diretoria")
	private Set<Meta> metas;

	@OneToMany(mappedBy = "diretoria")
	private Set<Usuario> usuarios;

	public Diretoria() {
		super();
	}

	public Diretoria(String nome) {
		super();
		this.nome = nome;
	}

	public int getIdDiretoria() {
		return idDiretoria;
	}

	public void setIdDiretoria(int idDiretoria) {
		this.idDiretoria = idDiretoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Meta> getMetas() {
		return metas;
	}

	public void setMetas(Set<Meta> metas) {
		this.metas = metas;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
