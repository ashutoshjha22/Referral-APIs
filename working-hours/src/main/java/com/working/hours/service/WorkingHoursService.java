package com.working.hours.service;



import java.util.List;

import com.working.hours.dto.WorkingHoursDTO;

public interface WorkingHoursService {

    WorkingHoursDTO createWorkingHours(WorkingHoursDTO workingHoursDTO);

    List<WorkingHoursDTO> getAllWorkingHours();

    WorkingHoursDTO getWorkingHoursByDay(String dayOfWeek);

    WorkingHoursDTO updateWorkingHours(Long id, WorkingHoursDTO workingHoursDTO);

    void deleteWorkingHours(Long id);
}
