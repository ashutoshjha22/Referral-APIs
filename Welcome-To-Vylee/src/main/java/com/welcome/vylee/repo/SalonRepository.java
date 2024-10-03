package com.welcome.vylee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.welcome.vylee.model.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
}
