package com.welcome.vylee.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int overallExperienceRating;
    
    @Lob
    private String comments;
    
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ServiceRating> serviceRatings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOverallExperienceRating() {
		return overallExperienceRating;
	}

	public void setOverallExperienceRating(int overallExperienceRating) {
		this.overallExperienceRating = overallExperienceRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<ServiceRating> getServiceRatings() {
		return serviceRatings;
	}

	public void setServiceRatings(List<ServiceRating> serviceRatings) {
		this.serviceRatings = serviceRatings;
	}

   
}
