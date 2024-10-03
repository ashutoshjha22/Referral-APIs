package com.vylee.vendor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor_Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	private Integer vendorId;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "salon_name")
	private String salonName;

	@Column(name = "vendor_email")
	private String vendorEmail;

	@Column(name = "mobile_Number")
	private Integer mobileNumber;

	@Column(name = "vendor_address")
	private String vendorAddress;

	@Column(name = "vendor_country")
	private String vendorCountry;

	@Column(name = "vendor_state")
	private String vendorState;

	@Column(name = "vendor_city")
	private String vendorCity;

	@Column(name = "pincode")
	private Integer pincode;

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSalonName() {
		return salonName;
	}

	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorCountry() {
		return vendorCountry;
	}

	public void setVendorCountry(String vendorCountry) {
		this.vendorCountry = vendorCountry;
	}

	public String getVendorState() {
		return vendorState;
	}

	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
	}

	public String getVensorCity() {
		return vendorCity;
	}

	public void setVensorCity(String vensorCity) {
		this.vendorCity = vensorCity;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Vendor_Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor_Registration(Integer vendorId, String fullName, String salonName, String vendorEmail,
			Integer mobileNumber, String vendorAddress, String vendorCountry, String vendorState, String vendorCity,
			Integer pincode) {
		super();
		this.vendorId = vendorId;
		this.fullName = fullName;
		this.salonName = salonName;
		this.vendorEmail = vendorEmail;
		this.mobileNumber = mobileNumber;
		this.vendorAddress = vendorAddress;
		this.vendorCountry = vendorCountry;
		this.vendorState = vendorState;
		this.vendorCity = vendorCity;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Vendor_Registration [vendorId=" + vendorId + ", fullName=" + fullName + ", salonName=" + salonName
				+ ", vendorEmail=" + vendorEmail + ", mobileNumber=" + mobileNumber + ", vendorAddress=" + vendorAddress
				+ ", vendorCountry=" + vendorCountry + ", vendorState=" + vendorState + ", vensorCity=" + vendorCity
				+ ", pincode=" + pincode + "]";
	}

}
