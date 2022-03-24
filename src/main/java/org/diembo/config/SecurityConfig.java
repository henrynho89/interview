package org.diembo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.servlet.oauth2.resourceserver.JwtDsl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	

	//------------------------------------AUTHENTICATION WITH JWT---------------------
	

	//------------------------------------------------------------------------------------
	//			how to do JDBC authentication and authorize with Spring Security
	//------------------------------------------------------------------------------------
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/desc/questionnaire/**","/desc/questionnaires/").hasAuthority("admin");
		http.authorizeRequests().antMatchers("/desc/questionnaires/").hasRole("user");
		http.exceptionHandling().accessDeniedPage("/desc/403");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------AUTHENTICATION WITH SESSION---------------
	
	
	//------------------------------------------------------------------------------------
	//			how to do JDBC authentication and authorize with Spring Security
	//------------------------------------------------------------------------------------
//	@Autowired
//	private UserDetailsService userDetailsService;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeRequests().antMatchers("/desc/questionnaire/**","/desc/questionnaires/").hasAuthority("admin");
//		http.authorizeRequests().antMatchers("/desc/questionnaires/").hasRole("user");
//		http.exceptionHandling().accessDeniedPage("/desc/403");
//	}
	
	//-----------------------------------------------------------------------------------------------------------
	

	//------------------------------------------------------------------------------------
	//			how to do JDBC authentication and authorize with Spring Security
	//------------------------------------------------------------------------------------
//	@Autowired
//	private DataSource dataSource;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select p.login, p.password, p.first_name, p.last_name from person where p.login=?")
//		.authoritiesByUsernameQuery("select p.login, r.name from role_person rp, role r, person"
//				+ "where rp.person_id=p.id and rp.role_id=r.id and p.login=?");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeRequests().antMatchers("/desc/questionnaire/**","/desc/questionnaires/").hasRole("admin");
//		http.authorizeRequests().antMatchers("/desc/questionnaires/").hasRole("user");
//		http.exceptionHandling().accessDeniedPage("/desc/403");
//	}
	
	//-----------------------------------------------------------------------------------------------------------

	

	//------------------------------------------------------------------------------------
	//			how to do in memory authentication and authorize with Spring Security
	//------------------------------------------------------------------------------------
//	@Autowired
//	private DataSource dataSource;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.withDefaultSchema()
//		.withUser(
//				User.withUsername("admin").password("{noop}1234").roles("admin","user"))
//		.withUser(
//				User.withUsername("user").password("{noop}1234").roles("user"));
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeRequests().antMatchers("/desc/questionnaire/**","/desc/questionnaires/").hasRole("admin");
//		http.authorizeRequests().antMatchers("/desc/questionnaires/").hasRole("user");
//		http.exceptionHandling().accessDeniedPage("/desc/403");
//	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	
	//------------------------------------------------------------------------------------
	//		how to do in memory authentication and authorize with Spring Security
	//------------------------------------------------------------------------------------
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("admin","user");
//		auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("user");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeRequests().antMatchers("/desc/questionnaire/**","/desc/questionnaires/").hasRole("admin");
//		http.authorizeRequests().antMatchers("/desc/questionnaires/").hasRole("user");
//		http.exceptionHandling().accessDeniedPage("/desc/403");
//	}
	

}
