package gov.gdg.modelo;

import gov.gdg.modelo.tipos.TipoPeso;
import gov.gdg.seguranca.SHA1Util;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 * 
 */
@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsuario;
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private int digito;
	@Column(unique = true)
	private String matricula;
	@Column
	private String senha;
	@Column
	private TipoPeso peso;
	@ManyToOne
	private Diretoria diretoria;
	@OneToMany(mappedBy = "usuario")
	private List<GrupoUsuario> grupoUsuarioList;

	public Usuario() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = SHA1Util.criptografaSenha(senha);;
	}

	public Diretoria getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(Diretoria diretoria) {
		this.diretoria = diretoria;
	}

	public TipoPeso getPeso() {
		return peso;
	}

	public void setPeso(TipoPeso peso) {
		this.peso = peso;
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		this.digito = digito;
	}

	public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
		this.grupoUsuarioList = grupoUsuarioList;
	}

	public List<GrupoUsuario> getGrupoUsuarioList() {
		return grupoUsuarioList;
	}

}
