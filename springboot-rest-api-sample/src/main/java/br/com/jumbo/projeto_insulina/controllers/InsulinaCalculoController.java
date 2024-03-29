
package br.com.jumbo.projeto_insulina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jumbo.projeto_insulina.model.InsulinaCalculaDose;
import br.com.jumbo.projeto_insulina.service.InsulinaCalculoService;

/**
 * @author João Paulo
 *
 *         29 de ago. de 2023 17:23:59
 */
@Controller
@RestController
public class InsulinaCalculoController {

	@Autowired
	private InsulinaCalculoService insulinaCalculoService;

	@PostMapping("/calculaInsulina")
	public ResponseEntity<String> calculaInsulina(@RequestBody InsulinaCalculaDose doseInsulina) {

		double insulinDose = insulinaCalculoService.calculaInsulinaDose(doseInsulina);

		String response = "A dose de insulina a ser aplicada é: " + insulinDose + " unidades.";

		return ResponseEntity.ok(response);
	}

}
