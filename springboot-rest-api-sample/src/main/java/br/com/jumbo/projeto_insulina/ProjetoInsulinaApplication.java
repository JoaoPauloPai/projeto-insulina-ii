package br.com.jumbo.projeto_insulina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author João Paulo
 *
 *         5 de mar. de 2023 18:01:22
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EntityScan(basePackages = "br.com.jumbo.projeto_insulina.model")
@ComponentScan(basePackages = { "br.*" })
@EnableJpaRepositories(basePackages = "br.com.jumbo.projeto_insulina.repository")
@EnableTransactionManagement
public class ProjetoInsulinaApplication implements AsyncConfigurer {
	
    public static void main(String[] args) {
    	
        SpringApplication.run(ProjetoInsulinaApplication.class, args);
    }
    
}
