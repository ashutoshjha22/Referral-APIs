package com.welcome.vylee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welcome.vylee.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {}
