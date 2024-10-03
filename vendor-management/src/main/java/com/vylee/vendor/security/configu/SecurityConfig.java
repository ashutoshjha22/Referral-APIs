package com.vylee.vendor.security.configu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity.authorizeHttpRequests(requests -> {

			requests.requestMatchers("/public/**").permitAll().requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/vendor/**").hasAnyRole("VENDOR").anyRequest().authenticated();

		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		PasswordEncoder encoder = passwordEncoder();

		UserDetails adminUser = User.builder().username("admin").password(encoder.encode("1234"))
				.roles("ADMIN", "VENDOR").build();

		UserDetails vendorUser = User.builder().username("vendor").password(encoder.encode("1234")).roles("VENDOR")
				.build();

		return new InMemoryUserDetailsManager(adminUser, vendorUser);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
}
