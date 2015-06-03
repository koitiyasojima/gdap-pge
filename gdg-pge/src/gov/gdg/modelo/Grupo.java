package gov.gdg.modelo;

import gov.gdg.modelo.tipos.TipoGrupo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 * 
 */
@Entity
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGrupo;

	@Column
	private String nome;
	
	@Column
	private TipoGrupo tipo;

	@OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
	private List<GrupoUsuario> grupoUsuarioList;

	public Grupo() {
		super();
		this.nome = "";
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
		this.grupoUsuarioList = grupoUsuarioList;
	}

	public List<GrupoUsuario> getGrupoUsuarioList() {
		return grupoUsuarioList;
	}
	
	public TipoGrupo getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoGrupo tipo) {
		this.tipo = tipo;
	}
}
