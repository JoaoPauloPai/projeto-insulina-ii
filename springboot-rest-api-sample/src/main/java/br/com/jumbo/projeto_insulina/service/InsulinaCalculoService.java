/**
 * 
 */
package br.com.jumbo.projeto_insulina.service;

import org.springframework.stereotype.Service;

import br.com.jumbo.projeto_insulina.model.InsulinaCalculaDose;

/**
 * @author João Paulo
 *
 *         29 de ago. de 2023 16:32:43
 */
@Service
public class InsulinaCalculoService {

	// Fator de carboidrato: quantas unidades de insulina por grama de carboidrato
	private static final double CARBO_FATOR = 0.5;

	// Fator de sensibilidade à insulina: quantas unidades de insulina por mg/dL de
	// glicose acima do alvo
	private static final double GLICOSE_FATOR = 0.1;

	public double calculaInsulinaDose(InsulinaCalculaDose doseInsulina) {

		double carboDoseCorrigida = doseInsulina.getQuantiCarbo() * CARBO_FATOR;
		double glicoseCorrigida = (doseInsulina.getNivelGlicose() - 100) * GLICOSE_FATOR;

		double totalDose = carboDoseCorrigida + glicoseCorrigida;

		return totalDose;
	}

}
