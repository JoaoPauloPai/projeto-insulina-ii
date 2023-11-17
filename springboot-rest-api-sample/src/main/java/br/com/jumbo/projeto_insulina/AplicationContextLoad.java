	/**
 * 
 */
package br.com.jumbo.projeto_insulina;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author João Paulo
 *
 * 6 de mar. de 2023
 * 21:05:11
 */
@Component
public class AplicationContextLoad implements ApplicationContextAware {

	@Autowired
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
