package pe.edu.upc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.demo.serviceimplements.JpaUserDetailsService;

@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	private BCryptPasswordEncoder passwordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private LoginSuccessHandler successHandler;

	protected void configure(HttpSecurity http) throws Exception {

		try {

			http.authorizeRequests().antMatchers("/*.js", "/*.css").permitAll().antMatchers("/uusuarios/**").permitAll()
					.antMatchers("/ccomentarios/**").access("hasRole('ROLE_MUSICO') or hasRole('ROLE_DUENIO')")
					.antMatchers("/ddistritos/**").access("hasRole('ROLE_ADMIN')").antMatchers("/fforma_pagos/**")
					.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MUSICO') or hasRole('ROLE_DUENIO')")
					.antMatchers("/mmarca_instrumentos/**").access("hasRole('ROLE_ADMIN')")
					.antMatchers("/ppublicaciones/**").access("hasRole('ROLE_MUSICO') or hasRole('ROLE_DUENIO')")
					.antMatchers("/rreservas/**").access("hasRole('ROLE_MUSICO') or hasRole('ROLE_DUENIO')")
					.antMatchers("/ttipoinstrumentos/**").access("hasRole('ROLE_ADMIN')").and().formLogin()
					.successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login")
					.defaultSuccessUrl("/fforma_pagos/new").permitAll().and().logout().logoutSuccessUrl("/login")
					.permitAll().and().exceptionHandling().accessDeniedPage("error");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}