package com.vylee.vendor.shop.gallery;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ShopGalleryService {

	List<ShopGallery> saveFile(List<MultipartFile> multipartFile, Integer vendorId) throws IOException;

}
