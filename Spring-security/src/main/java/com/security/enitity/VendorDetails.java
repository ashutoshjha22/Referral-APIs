package com.security.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VendorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendorId;
	private String vendorName;
	private String vendorEmail;
	private String vendorpwd;
	private String role;

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorpwd() {
		return vendorpwd;
	}

	public void setVendorpwd(String vendorpwd) {
		this.vendorpwd = vendorpwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public VendorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
