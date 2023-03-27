/**
 * 
 */
package br.com.jumbo.projeto_insulina;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author João Paulo
 *
 *         26 de mar. de 2023 19:31:09
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(ProjetoInsulinaApplication.class);
	}
}
