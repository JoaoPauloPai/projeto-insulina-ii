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
 *         12 de mar. de 2023 15:37:31
 */

@Entity
@Table(name = "paciente")
@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1, initialValue = 1)
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	private Long id;

	@NotNull(message = "O nome do paciente deve ser Informado")
	@Column(nullable = false)
	private String nome;

	@NotNull(message = "O sexo do paciente deve ser Informado")
	@Column(nullable = false)
	private char sexo;

	@NotNull(message = "A idade do paciente deve ser Informada")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNascimento;

	@NotNull(message = "O grau de parentesco deve ser Informado")
	@Column(nullable = false)
	private String grauParentesco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
