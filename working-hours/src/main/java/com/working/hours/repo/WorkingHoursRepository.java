package com.working.hours.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.working.hours.model.WorkingHours;

@Repository
public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {
    List<WorkingHours> findByDayOfWeek(String dayOfWeek);
}
