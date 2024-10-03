package com.vylee.upload.document.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class BusinessDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
    private String identityProofType;
	
	@Column(nullable = false)
    private String shopRegistrationFilePath;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentityProofType() {
		return identityProofType;
	}
	public void setIdentityProofType(String identityProofType) {
		this.identityProofType = identityProofType;
	}
	public String getShopRegistrationFilePath() {
		return shopRegistrationFilePath;
	}
	public void setShopRegistrationFilePath(String shopRegistrationFilePath) {
		this.shopRegistrationFilePath = shopRegistrationFilePath;
	}
	
   }
