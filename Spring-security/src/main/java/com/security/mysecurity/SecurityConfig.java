package com.security.mysecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomAccesDeniedHandler accesDeniedHandler;

	@Autowired
	private CustomVendorDetailsService customVendorDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(requests -> {

			requests.requestMatchers("/public/**").permitAll().requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/vendor/**").hasAnyRole("VENDOR").anyRequest().authenticated();

		}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.exceptionHandling(exception -> exception.accessDeniedHandler(accesDeniedHandler)).build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(customVendorDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//
//		PasswordEncoder encoder = passwordEncoder();
//
//		UserDetails adminUser = User.builder().username("admin").password(encoder.encode("1234"))
//				.roles("ADMIN", "VENDOR").build();
//
//		UserDetails vendorUser = User.builder().username("vendor").password(encoder.encode("1234")).roles("VENDOR")
//				.build();
//
//		return new InMemoryUserDetailsManager(adminUser, vendorUser);
//
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
}
