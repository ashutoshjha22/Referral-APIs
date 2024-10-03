package com.vylee.vendor.addlisting.servicecategory;

import org.springframework.stereotype.Component;

import com.vylee.vendor.addlisting.entity.ProductSubCategory;
import com.vylee.vendor.addlisting.entity.ServiceProduct;

@Component
public class ResponseProductAndSubCategory {

	private ServiceProduct serviceProduct;

	private ProductSubCategory productSubCategory;

	private String message;

	public ServiceProduct getServiceProduct() {
		return serviceProduct;
	}

	public void setServiceProduct(ServiceProduct serviceProduct) {
		this.serviceProduct = serviceProduct;
	}

	public ProductSubCategory getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(ProductSubCategory productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseProductAndSubCategory(ServiceProduct serviceProduct, ProductSubCategory productSubCategory,
			String message) {
		super();
		this.serviceProduct = serviceProduct;
		this.productSubCategory = productSubCategory;
		this.message = message;
	}

	public ResponseProductAndSubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
