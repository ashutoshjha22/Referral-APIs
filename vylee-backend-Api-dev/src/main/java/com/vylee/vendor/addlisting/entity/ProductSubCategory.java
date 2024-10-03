package com.vylee.vendor.addlisting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_sub_category")
public class ProductSubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subCategoryId;

	private String subCategoryName;

	private Integer Price;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private ServiceProduct serviceProduct;

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public ServiceProduct getServiceProduct() {
		return serviceProduct;
	}

	public void setServiceProduct(ServiceProduct serviceProduct) {
		this.serviceProduct = serviceProduct;
	}

	public ProductSubCategory(Integer subCategoryId, String subCategoryName, Integer price,
			ServiceProduct serviceProduct) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		Price = price;
		this.serviceProduct = serviceProduct;
	}

	public ProductSubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
