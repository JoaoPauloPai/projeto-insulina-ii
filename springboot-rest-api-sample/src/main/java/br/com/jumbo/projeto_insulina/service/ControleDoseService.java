/**
 * 
 */
package br.com.jumbo.projeto_insulina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jumbo.projeto_insulina.model.ControleDose;
import br.com.jumbo.projeto_insulina.repository.ControleDoseRepository;

/**
 * @author João Paulo
 *
 *         11 de set. de 2023 14:48:54
 */
@Service
public class ControleDoseService {

	@Autowired
	private ControleDoseRepository controleDoseRepository;

	/**
	 * @param controleDose
	 * @return
	 */
	public ControleDose salvarControleDose(ControleDose controleDose1) {

		ControleDose novoControleDose = new ControleDose();
		novoControleDose.setData(controleDose1.getData());
		novoControleDose.setDoseAplicada(controleDose1.getDoseAplicada());
		novoControleDose.setPaciente(controleDose1.getPaciente());
		
		// novoUsuario.setEmail(usuario1.getEmail());
		// novoUsuario.setLogin(usuario1.getLogin());
		// novoUsuario.setNome(usuario1.getNome());
		//
	

		controleDoseRepository.save(novoControleDose);
		
		return novoControleDose;
	}

}
