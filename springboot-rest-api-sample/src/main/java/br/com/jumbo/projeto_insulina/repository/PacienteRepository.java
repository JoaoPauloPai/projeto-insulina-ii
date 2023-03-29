/**
 * 
 */
package br.com.jumbo.projeto_insulina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jumbo.projeto_insulina.model.Paciente;
import br.com.jumbo.projeto_insulina.model.Usuario;

/**
 * @author João Paulo
 *
 * 28 de mar. de 2023
 * 20:48:45
 */
@Repository
@Transactional
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	@Query("select p from Paciente p where p.usario == %?1%")
	List<Paciente> buscaPacienteUsuarioId(Long usuario);




}
