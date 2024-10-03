package com.salon.information.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.information.model.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
    // Custom queries can be added if needed
}
