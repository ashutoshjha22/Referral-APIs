package com.vylee.vendor.shop.gallery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ShopGalleryimpl implements ShopGalleryService {

	@Autowired
	private ShopGalleryRepository shopGalleryRepository;

	
	@Override
	public List<ShopGallery> saveFile(List<MultipartFile> multipartFiles, Integer vendorId) throws IOException {
		List<ShopGallery> savedFiles = new ArrayList<>();

		for (MultipartFile file : multipartFiles) {
			// Extract file details for each file
			String fileName = file.getOriginalFilename();
			String fileType = file.getContentType();
			byte[] data = file.getBytes();

			// Create the ShopGallery entity
			ShopGallery shopGallery = new ShopGallery(vendorId, vendorId, fileName, fileType, data);

			// Save the file in the repository
			savedFiles.add(shopGalleryRepository.save(shopGallery));
		}

		return savedFiles; // Return the list of saved ShopGallery entities
	}

}
