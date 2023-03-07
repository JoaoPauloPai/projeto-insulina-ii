/**
 * 
 */
package br.com.jumbo.projeto_insulina.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author João Paulo
 *
 * 5 de mar. de 2023
 * 18:03:43
 */
@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;

	@NotNull(message = "O Login do Usuario deve ser Informado")
	@Column(nullable = false, unique = true)
	private String login;

	@NotNull(message = "A senha deve ser Informada")
	@Column(nullable = false)
	private String senha;
	
	@NotNull(message = "O nome do Usuario deve ser Informado")
	@Column(nullable = false)
	private String nome;
	
	@NotNull(message = "O Email do Usuario deve ser Informado")
	@Column(nullable = false)
	private String email;



	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	
	

}
