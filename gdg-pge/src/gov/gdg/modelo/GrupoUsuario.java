package gov.gdg.modelo;

import gov.gdg.modelo.tipos.TipoCargo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GrupoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGrupoUsuario;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Grupo grupo;

	@Column
	@Enumerated(EnumType.STRING)
	private TipoCargo cargo;

	public GrupoUsuario() {
	}

	public int getIdGrupoUsuario() {
		return idGrupoUsuario;
	}

	public void setIdGrupoUsuario(int idGrupoUsuario) {
		this.idGrupoUsuario = idGrupoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public TipoCargo getCargo() {
		return cargo;
	}

	public void setCargo(TipoCargo cargo) {
		this.cargo = cargo;
	}

}
