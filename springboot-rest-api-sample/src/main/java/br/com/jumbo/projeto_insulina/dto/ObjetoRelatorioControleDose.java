/**
 * 
 */
package br.com.jumbo.projeto_insulina.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

/**
 * @author João Paulo
 *
 *         24 de set. de 2023 19:50:30
 */
public class ObjetoRelatorioControleDose implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Informa a data inicial")
	private String dataInicial;

	@NotEmpty(message = "Informa a data final")
	private String dataFinal;

	private String codigoPaciente = "";
	
	private String nomeUsuario = "";

	private String nomePaciente = "";

	private String sexo = "";

	private String doseAplicada = "";

	public String getDataInicial() {
		return dataInicial;
	}
	
	
	

	public String getNomeUsuario() {
		return nomeUsuario;
	}




	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}




	public String getCodigoPaciente() {
		return codigoPaciente;
	}


	public void setCodigoPaciente(String codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}


	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}



	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDoseAplicada() {
		return doseAplicada;
	}

	public void setDoseAplicada(String doseAplicada) {
		this.doseAplicada = doseAplicada;
	}


}
