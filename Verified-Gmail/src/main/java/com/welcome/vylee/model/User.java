package com.welcome.vylee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable = false)
    private String name;
	
	@Column(nullable = false)
    private String email;
	
	@Column(nullable = false)
    private String password;
	
	
    @Column(nullable = false)
    private boolean isEmailVerified = false;
    
	@Column(nullable = false)
    private String verificationToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}

	public User(Long id, String name, String email, String password, boolean isEmailVerified,
			String verificationToken) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isEmailVerified = isEmailVerified;
		this.verificationToken = verificationToken;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
   
}
