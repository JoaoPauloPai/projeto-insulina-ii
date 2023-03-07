/**
 * 
 */
package br.com.jumbo.projeto_insulina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jumbo.projeto_insulina.model.Usuario;

/**
 * @author João Paulo
 *
 * 6 de mar. de 2023
 * 20:37:28
 */
@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
