package com.vylee.vendor.addlisting.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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


	@ManyToOne
	@JoinColumn(name = "category_id")
	private ServiceCategory serviceCategory;

	 @OneToMany(mappedBy = "serviceProduct", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductSubCategory> subCategories = new ArrayList<ProductSubCategory>();

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
		this.serviceCategory = serviceCategory;
	}

	public ServiceProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

}
