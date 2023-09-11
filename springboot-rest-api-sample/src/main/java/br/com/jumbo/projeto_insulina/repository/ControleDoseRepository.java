/**
 * 
 */
package br.com.jumbo.projeto_insulina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jumbo.projeto_insulina.model.ControleDose;

/**
 * @author João Paulo
 *
 * 11 de set. de 2023
 * 15:07:43
 */
@Repository
@Transactional
public interface ControleDoseRepository extends JpaRepository<ControleDose, Long>{

}
