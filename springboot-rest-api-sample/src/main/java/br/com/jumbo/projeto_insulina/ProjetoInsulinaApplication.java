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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EntityScan(basePackages = "br.com.jumbo.projeto_insulina.model")
@ComponentScan(basePackages = { "br.*" })
@EnableJpaRepositories(basePackages = "br.com.jumbo.projeto_insulina.repository")
@EnableTransactionManagement
@EnableWebMvc
public class ProjetoInsulinaApplication implements AsyncConfigurer, WebMvcConfigurer {
	
    public static void main(String[] args) {
    	
        SpringApplication.run(ProjetoInsulinaApplication.class, args);
    }
}
