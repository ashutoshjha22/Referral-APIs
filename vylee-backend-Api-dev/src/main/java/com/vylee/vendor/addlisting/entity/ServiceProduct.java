package com.vylee.vendor.addlisting.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ServiceProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceId;

	private String serviceName;

	private Integer servicePrice;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceCategory;

	@OneToMany
	private List<ProductSubCategory> subCategories;

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}

	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public ServiceProduct(Integer serviceId, String serviceName, Integer servicePrice,
			ServiceCategory serviceCategory) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
		this.serviceCategory = serviceCategory;
	}

	public ServiceProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

}
