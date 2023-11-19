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
	private static final double CARB_RATIO = 0.5;

	// Fator de sensibilidade à insulina: quantas unidades de insulina por mg/dL de
	// glicose acima do alvo
	private static final double SENSITIVITY_FACTOR = 0.1;

	public double calculateInsulinDose(InsulinaCalculaDose input) {

		double carbDose = input.getQuantiCarbo() * CARB_RATIO;
		double glucoseCorrection = (input.getNivelGlicose() - 100) * SENSITIVITY_FACTOR;

		double totalDose = carbDose + glucoseCorrection;

		return totalDose;
	}

}
