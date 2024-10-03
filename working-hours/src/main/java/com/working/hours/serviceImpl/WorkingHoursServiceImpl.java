package com.working.hours.serviceImpl;


import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.working.hours.dto.WorkingHoursDTO;
import com.working.hours.model.WorkingHours;
import com.working.hours.repo.WorkingHoursRepository;
import com.working.hours.service.WorkingHoursService;

@Service
public class WorkingHoursServiceImpl implements WorkingHoursService {

    private final WorkingHoursRepository workingHoursRepository;

    public WorkingHoursServiceImpl(WorkingHoursRepository workingHoursRepository) {
        this.workingHoursRepository = workingHoursRepository;
    }

    @Override
    public WorkingHoursDTO createWorkingHours(WorkingHoursDTO workingHoursDTO) {
        WorkingHours workingHours = new WorkingHours();
        workingHours.setDayOfWeek(workingHoursDTO.getDayOfWeek());
        workingHours.setOpenTime(LocalTime.parse(workingHoursDTO.getOpenTime()));
        workingHours.setCloseTime(LocalTime.parse(workingHoursDTO.getCloseTime()));
        workingHours.setActive(workingHoursDTO.getActive());

        workingHoursRepository.save(workingHours);

        return convertToDTO(workingHours);
    }

    @Override
    public List<WorkingHoursDTO> getAllWorkingHours() {
        return workingHoursRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WorkingHoursDTO getWorkingHoursByDay(String dayOfWeek) {
        return workingHoursRepository.findByDayOfWeek(dayOfWeek)
                .stream()
                .map(this::convertToDTO)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No working hours found for " + dayOfWeek));
    }

    @Override
    public WorkingHoursDTO updateWorkingHours(Long id, WorkingHoursDTO workingHoursDTO) {
        WorkingHours workingHours = workingHoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Working hours not found with id: " + id));

        workingHours.setDayOfWeek(workingHoursDTO.getDayOfWeek());
        workingHours.setOpenTime(LocalTime.parse(workingHoursDTO.getOpenTime()));
        workingHours.setCloseTime(LocalTime.parse(workingHoursDTO.getCloseTime()));
        workingHours.setActive(workingHoursDTO.getActive());

        workingHoursRepository.save(workingHours);
        return convertToDTO(workingHours);
    }

    @Override
    public void deleteWorkingHours(Long id) {
        WorkingHours workingHours = workingHoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Working hours not found with id: " + id));

        workingHoursRepository.delete(workingHours);
    }

    private WorkingHoursDTO convertToDTO(WorkingHours workingHours) {
        WorkingHoursDTO dto = new WorkingHoursDTO();
        dto.setDayOfWeek(workingHours.getDayOfWeek());
        dto.setOpenTime(workingHours.getOpenTime().toString());
        dto.setCloseTime(workingHours.getCloseTime().toString());
        dto.setActive(workingHours.isActive());
        return dto;
    }
}
