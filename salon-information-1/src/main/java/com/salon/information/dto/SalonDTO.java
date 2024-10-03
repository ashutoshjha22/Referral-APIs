package com.salon.information.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
public class SalonDTO {
    
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Website cannot be empty")
    @Pattern(regexp = "^(http|https)://.*$", message = "Invalid website URL")
    private String website;

    @NotBlank(message = "WhatsApp number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid WhatsApp number")
    private String whatsappNumber;

    private String logoFileName;  // URL or file name of the uploaded logo

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	
}
