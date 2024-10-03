package com.vylee.vendor.addlisting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vylee.vendor.addlisting.entity.ServiceProduct;

public interface ServiceRepository extends JpaRepository<ServiceProduct, Integer> {

	 @Query("SELECT p FROM ServiceProduct p WHERE p.serviceCategory.categoryId = :categoryId")
	    List<ServiceProduct> findServiceProductByCategory(@Param("categoryId") Integer categoryId);

}
