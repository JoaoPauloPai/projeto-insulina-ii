/**
 * 
 */
package br.com.jumbo.projeto_insulina.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

/**
 * @author João Paulo
 *
 *         12 de mar. de 2023 15:54:56
 */
@Entity
@Table(name = "controle_dose")
@SequenceGenerator(name = "seq_controle_dose", sequenceName = "seq_controle_dose", allocationSize = 1, initialValue = 1)
public class ControleDose implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_controle_dose")
	private Long id;

	@NotNull(message = "A dose deve ser Informado")
	@Column(nullable = false)
	private double doseAplicada;

	@NotNull(message = "A data deve ser Informada")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data;

	@ManyToOne(targetEntity = Paciente.class)
	@JoinColumn(name = "paciente_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "paciente_fk"))
	private Paciente paciente;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getDoseAplicada() {
		return doseAplicada;
	}

	public void setDoseAplicada(double doseAplicada) {
		this.doseAplicada = doseAplicada;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		ControleDose other = (ControleDose) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
