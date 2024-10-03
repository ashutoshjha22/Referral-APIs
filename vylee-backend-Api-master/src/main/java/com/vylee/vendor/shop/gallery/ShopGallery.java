package com.vylee.vendor.shop.gallery;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ShopGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer vendorId;

    private String fileName;

    private String fileType;

    @Lob
    @Column(name = "images", columnDefinition = "LONGBLOB")
    private byte[] data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public ShopGallery(Integer id, Integer vendorId, String fileName, String fileType, byte[] data) {
		super();
		this.id = id;
		this.vendorId = vendorId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	public ShopGallery() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ShopGallery [id=" + id + ", vendorId=" + vendorId + ", fileName=" + fileName + ", fileType=" + fileType
				+ ", data=" + Arrays.toString(data) + "]";
	}
    
    
    
   

   

}
