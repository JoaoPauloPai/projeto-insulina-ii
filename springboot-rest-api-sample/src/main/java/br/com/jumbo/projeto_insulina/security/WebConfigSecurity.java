/**
 * 
 */
package br.com.jumbo.projeto_insulina.security;

import org.springframework.context.annotation.Configuration;

/**
 * @author João Paulo
 *
 *         26 de mar. de 2023 19:39:20
 */
@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebConfigSecurity {// extends WebSecurityConfigurerAdapter implements HttpSessionListener {

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {

	/**
	 * http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	 * .disable().authorizeRequests().antMatchers("/").permitAll()
	 * .antMatchers("/index","/usuario/**","/resources/**","/static/**","/templates/**","classpath:/static/**","classpath:/resources/**","classpath:/templates/**").permitAll()
	 * .antMatchers(HttpMethod.POST,
	 * "/usuario/**","/resources/**","/static/**","/templates/**","classpath:/static/**","classpath:/resources/**","classpath:/templates/**").permitAll()
	 * .antMatchers(HttpMethod.GET,
	 * "/usuario/**","/resources/**","/static/**","/templates/**","classpath:/static/**","classpath:/resources/**","classpath:/templates/**").permitAll()
	 * .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	 * 
	 * /* redireciona ou da um retorno para index quando desloga
	 */
	// .anyRequest().authenticated().and().logout().logoutSuccessUrl("/index");

	/* mapeia o logout do sistema */
	// .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

	/* Filtra as requisicoes para login de JWT */
	// .and()
	// .addFilterAfter(new JWTLoginFilter("/login", authenticationManager()),
	// UsernamePasswordAuthenticationFilter.class)

	// .addFilterBefore(new JwtApiAutenticationFilter(),
	// UsernamePasswordAuthenticationFilter.class);

	// }

	/* Ignora a autenticação */
	// @Override
	// public void configure(WebSecurity web) throws Exception {

	// web.ignoring().
	// antMatchers(HttpMethod.GET,
	// "/usuario/**","/resources/**","/static/**","/templates/**","classpath:/static/**","classpath:/resources/**","classpath:/templates/**","/webjars/**","/WEB-INF/classes/static/**")
	// .antMatchers(HttpMethod.POST,
	// "/usuario/**","/resources/**","/static/**","/templates/**","classpath:/static/**","classpath:/resources/**","classpath:/templates/**","/webjars/**","/WEB-INF/classes/static/**");
	/* Ingnorando URL no momento para nao autenticar */
	// }

}
