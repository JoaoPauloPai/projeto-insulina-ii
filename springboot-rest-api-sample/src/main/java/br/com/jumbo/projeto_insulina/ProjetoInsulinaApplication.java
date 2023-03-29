package br.com.jumbo.projeto_insulina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
public class ProjetoInsulinaApplication implements AsyncConfigurer {
	
    public static void main(String[] args) {
    	
        SpringApplication.run(ProjetoInsulinaApplication.class, args);
    }
    
	//@Bean
	//public ViewResolver  viewResolver() {
		
		//InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		//viewResolver.setPrefix("classpath:templates/");
		//viewResolver.setSuffix(".html");
		
		//return viewResolver;
	//}
}
