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
 * 12 de mar. de 2023
 * 15:54:56
 */
@Entity
@Table(name = "controle_dose")
@SequenceGenerator(name = "seq_controle_dose", sequenceName = "seq_controle_dose", allocationSize = 1, initialValue = 1)
public class ControleDose implements Serializable{
	
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
	
	

}
