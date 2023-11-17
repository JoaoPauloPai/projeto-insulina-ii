	/**
 * 
 */
package br.com.jumbo.projeto_insulina;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author João Paulo
 *
 * 24 de mar. de 2023
 * 15:50:23
 */
@RestControllerAdvice
@ControllerAdvice
public class ControleExcecoes extends ResponseEntityExceptionHandler {

}
