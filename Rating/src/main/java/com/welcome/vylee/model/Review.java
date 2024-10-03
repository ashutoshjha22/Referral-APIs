package com.welcome.vylee.model;

import jakarta.persistence.*;
import java.util.List;

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
