package com.vylee.vendor.addlisting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vylee.vendor.addlisting.entity.ProductSubCategory;

public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Integer> {
	
	@Query("SELECT psc FROM ProductSubCategory psc WHERE psc.serviceProduct.serviceId = :serviceId")
	List<ProductSubCategory> findSubCategoriesByServiceId(@Param("serviceId") Integer serviceId);

}
