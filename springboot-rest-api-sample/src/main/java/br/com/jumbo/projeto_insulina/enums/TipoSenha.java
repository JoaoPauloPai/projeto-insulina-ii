/**
 * 
 */
package br.com.jumbo.projeto_insulina.enums;

/**
 * @author João Paulo
 *
 *         2 de nov. de 2023 20:45:33
 */
public enum TipoSenha {

	SIMPLES("simples"), CRYPTO("crypto");

	private String descricao;

	private TipoSenha(String descricao) {
		this.descricao = descricao;

	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {

		return this.toString();
	}

}
