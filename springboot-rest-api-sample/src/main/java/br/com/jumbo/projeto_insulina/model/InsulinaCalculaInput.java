	/**
 * 
 */
package br.com.jumbo.projeto_insulina.model;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * @author João Paulo
 *
 *         29 de ago. de 202 15:17:59
 */

public class InsulinaCalculaInput implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;


	private double quantiCarbo; // Quantidade de carboidratos em gramas
	
	private double nivelGlicose; // Nível de glicose no sangue em mg/dL
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getQuantiCarbo() {
		return quantiCarbo;
	}
	public void setQuantiCarbo(double quantiCarbo) {
		this.quantiCarbo = quantiCarbo;
	}
	public double getNivelGlicose() {
		return nivelGlicose;
	}
	public void setNivelGlicose(double nivelGlicose) {
		this.nivelGlicose = nivelGlicose;
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
		InsulinaCalculaInput other = (InsulinaCalculaInput) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
