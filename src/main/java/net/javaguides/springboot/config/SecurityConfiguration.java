package net.javaguides.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.javaguides.springboot.service.UserService;

@Configuration // Spring Configuration annotation indicates that the class has @Bean definition
				// methods.
@EnableWebSecurity

//marker annotation
public class SecurityConfiguration {

	@Autowired // enables automatic dependency injection
	// all the bean dependencies in a Spring configuration file, Spring container
	// can autowire relationships between collaborating beans
	private UserService userService;

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests((authorize) -> authorize.requestMatchers("/registration**").permitAll()
				.requestMatchers("/js/**").permitAll().requestMatchers("/css/**").permitAll().requestMatchers("/img/**")
				.permitAll().requestMatchers("/").permitAll().requestMatchers("/showNewEmployeeForm").permitAll()
				.requestMatchers("/saveEmployee").permitAll().requestMatchers("/deleteEmployee/{id}").permitAll()
				.requestMatchers("/showFormForUpdate/{id}").permitAll().requestMatchers("/page/{pageNo}").permitAll()
				.requestMatchers("/About").permitAll().requestMatchers("/Home").permitAll()

		).formLogin(form -> form.loginPage("/login").permitAll())
				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
}
