package com.vylee.vendor.addlisting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vylee.vendor.addlisting.entity.ServiceCategory;

public interface CategoryRepository extends JpaRepository<ServiceCategory, Integer> {

	List<ServiceCategory> findByCategoryName(String cetegoryName);

}
