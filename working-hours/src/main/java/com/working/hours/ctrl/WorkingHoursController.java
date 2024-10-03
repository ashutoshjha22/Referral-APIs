package com.working.hours.ctrl;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.hours.dto.WorkingHoursDTO;
import com.working.hours.service.WorkingHoursService;

@RestController
@RequestMapping("/api/working-hours")
public class WorkingHoursController {

    private final WorkingHoursService workingHoursService;

    public WorkingHoursController(WorkingHoursService workingHoursService) {
        this.workingHoursService = workingHoursService;
    }

    @PostMapping
    public ResponseEntity<WorkingHoursDTO> createWorkingHours(@RequestBody WorkingHoursDTO workingHoursDTO) {
        WorkingHoursDTO createdWorkingHours = workingHoursService.createWorkingHours(workingHoursDTO);
        return new ResponseEntity<>(createdWorkingHours, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WorkingHoursDTO>> getAllWorkingHours() {
        List<WorkingHoursDTO> workingHoursList = workingHoursService.getAllWorkingHours();
        return new ResponseEntity<>(workingHoursList, HttpStatus.OK);
    }

    @GetMapping("/{day}")
    public ResponseEntity<WorkingHoursDTO> getWorkingHoursByDay(@PathVariable("day") String dayOfWeek) {
        WorkingHoursDTO workingHours = workingHoursService.getWorkingHoursByDay(dayOfWeek);
        return new ResponseEntity<>(workingHours, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkingHoursDTO> updateWorkingHours(@PathVariable Long id, @RequestBody WorkingHoursDTO workingHoursDTO) {
        WorkingHoursDTO updatedWorkingHours = workingHoursService.updateWorkingHours(id, workingHoursDTO);
        return new ResponseEntity<>(updatedWorkingHours, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkingHours(@PathVariable Long id) {
        workingHoursService.deleteWorkingHours(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
