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
 *         6 de mar. de 2023 20:37:28
 */
@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u where upper(trim(u.login)) like %?1%")
	List<Usuario> buscaUsuarioLogin(String login);

	@Query("select u from Usuario u where upper(trim(u.email)) like %?1%")
	List<Usuario> buscaUsuarioEmail(String email);

	@Query("select u from Usuario u where upper(trim(u.login)) like %?1%")
	List<Usuario> buscaUsuarioPorDesc(String login);

	@Query("select u from Usuario u where upper(trim(u.nome)) like %?1%")
	List<Usuario> buscaUsuarioPorNome(String nome);

	@Query("select u from Usuario u where upper(trim(u.email)) like %?1%")
	List<Usuario> buscaUsuarioPorEmail(String upperCase);

	@Query("select u from Usuario u where u.email like %?1%")
	List<Usuario> logarUsuarioEmail(String email);

	@Query("select u from Usuario u where u.id = ?1")
	Paciente consultaIdUsuario(Long id);

	@Query("select u from Usuario u where u.id = ?1")
	List<Usuario> buscaUsuarioId(Long id);

	

}
