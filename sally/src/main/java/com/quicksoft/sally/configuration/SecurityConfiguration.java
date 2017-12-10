package com.quicksoft.sally.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	@Qualifier("clienteService")
	private UserDetailsService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/*","/fonts/*","/font-awesome/*","/img/landing/*","/js/*","/locales/*","/pdf/*","/sally/inicio","/sally/registro","/sally/cliente","/sally/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/sally/login").loginProcessingUrl("/sally/logincheck")
		.usernameParameter("correo").passwordParameter("contraseña")
		.defaultSuccessUrl("/dashboard",true).permitAll()
		.and().logout().logoutUrl("/sally/logout").logoutSuccessUrl("/sally/login?logout").permitAll(); 
	}
}
