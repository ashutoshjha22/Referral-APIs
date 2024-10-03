package com.vylee.vendor.addlisting.servicecategory;

import java.util.List;

import com.vylee.vendor.addlisting.entity.ProductSubCategory;
import com.vylee.vendor.addlisting.entity.ServiceCategory;
import com.vylee.vendor.addlisting.entity.ServiceProduct;

public interface ListingServices {


	String addCategory(ServiceCategory serviceCategory);

	List<ServiceProduct> getServiceByCategoryName(String categoryName);

	String AddServices(ServiceProduct serviceProduct, Integer categoryId);

	String addSubCategory(ProductSubCategory productSubCategory, Integer productServiceId);

}
