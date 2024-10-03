package com.vylee.vendor.addlisting.servicecategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vylee.vendor.addlisting.entity.ProductSubCategory;
import com.vylee.vendor.addlisting.entity.ServiceCategory;
import com.vylee.vendor.addlisting.entity.ServiceProduct;
import com.vylee.vendor.addlisting.repository.CategoryRepository;
import com.vylee.vendor.addlisting.repository.ProductSubCategoryRepository;
import com.vylee.vendor.addlisting.repository.ServiceRepository;

@Service
public class ListingServicesImpl implements ListingServices {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;

	@Override
	public String addCategory(ServiceCategory serviceCategory) {
		// TODO Auto-generated method stub

		ServiceCategory serviceCategorySaved = categoryRepository.save(serviceCategory);
		if (serviceCategorySaved != null) {

			return "One Category Added";
		} else {
			return "Category Not Added...!!";
		}
	}

//	@Override
//	public List<ServiceProduct> getServiceByCategoryName(String categoryName) {
//		// TODO Auto-generated method stub
//		List<ServiceProduct> findByServiceCategory = null;
//		List<ServiceCategory> getServicesByCategory = categoryRepository.findByCategoryName(categoryName);
//
//		if (getServicesByCategory != null) {
//
//			for (ServiceCategory category : getServicesByCategory) {
//
//				findByServiceCategory = serviceRepository.findServiceProductByCategory(category.getCategoryId());
//			}
//
//		}
//		return findByServiceCategory;
//	}

	@Override
	public String AddServices(ServiceProduct serviceProduct, Integer categoryId) {
		// TODO Auto-generated method stub
		ServiceCategory getCategory = null;
		// getting category based on the category Id

		Optional<ServiceCategory> findById = categoryRepository.findById(categoryId);

		getCategory = findById.orElseThrow();

		// setting the category in the service
		serviceProduct.setServiceCategory(getCategory);
		ServiceProduct serviceProductSaved = serviceRepository.save(serviceProduct);
		if (serviceProductSaved != null) {

			return "One Service Added";
		} else {
			return "Service Nopt Added..!!";
		}
	}

	@Override
	public String addSubCategory(ProductSubCategory productSubCategory, Integer productServiceId) {
		// TODO Auto-generated method stub
		ServiceProduct serviceProduct = null;

		// getting Product based on product Service Id
		Optional<ServiceProduct> findById = serviceRepository.findById(productServiceId);

		if (findById.isPresent()) {
			serviceProduct = findById.get();
		} else {
			return "Product Service Not Found....!!";
		}

		// setting product service in the sub category
		productSubCategory.setServiceProduct(serviceProduct);

		// save the sub category
		ProductSubCategory productSubCategorySaved = productSubCategoryRepository.save(productSubCategory);

		if (productSubCategorySaved != null) {
			return "Sub Category Added";
		} else {
			return "Sub Category Not Added...!!";
		}
	}

	@Override
	public ResponseProductAndSubCategory getServiceByCategoryNames(String categoryName) {
		List<ServiceProduct> findByServiceCategory = new ArrayList<>();
		List<ProductSubCategory> subCategoriesByServiceId = new ArrayList<>();
		ResponseProductAndSubCategory responseProductAndSubCategory = new ResponseProductAndSubCategory();

		// Find the category by category name
		List<ServiceCategory> byCategoryName = categoryRepository.findByCategoryName(categoryName);

		if (byCategoryName == null || byCategoryName.isEmpty()) {
			responseProductAndSubCategory.setMessage("No data available for the provided category name.");
			return responseProductAndSubCategory;
		}

		// Find the service products by category
		for (ServiceCategory category : byCategoryName) {
			List<ServiceProduct> serviceProducts = serviceRepository
					.findServiceProductByCategory(category.getCategoryId());
			if (serviceProducts != null) {
				findByServiceCategory.addAll(serviceProducts);
			}
		}

		if (findByServiceCategory.isEmpty()) {
			responseProductAndSubCategory.setMessage("No service products available for the provided category name.");
			return responseProductAndSubCategory;
		}

		// Find sub categories for each service product
		for (ServiceProduct product : findByServiceCategory) {
			List<ProductSubCategory> subCategories = productSubCategoryRepository
					.findSubCategoriesByServiceId(product.getServiceId());
			if (subCategories != null) {
				subCategoriesByServiceId.addAll(subCategories);
				responseProductAndSubCategory.setServiceProduct(product);
				responseProductAndSubCategory.setMessage("Data Found..!!");
			}
		}

		if (subCategoriesByServiceId.isEmpty()) {
			responseProductAndSubCategory.setMessage("No subcategories available for the provided service ID.");
			return responseProductAndSubCategory;
		}

		// Set the sub categories in the response
		for (ProductSubCategory productSubCategory : subCategoriesByServiceId) {
			responseProductAndSubCategory.setProductSubCategory(productSubCategory);
			responseProductAndSubCategory.setMessage("Data Found..!!");
		}

		return responseProductAndSubCategory;
	}
	
	

}