package com.salon.information.ctrl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.salon.information.dto.SalonDTO;
import com.salon.information.service.SalonService;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    private final SalonService salonService;

    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(
            @RequestPart("salon") SalonDTO salonDTO,
            @RequestPart(value = "logoFile", required = false) MultipartFile logoFile) {
        SalonDTO createdSalon = salonService.createSalon(salonDTO, logoFile);
        return new ResponseEntity<>(createdSalon, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalonDTO> getSalonById(@PathVariable Long id) {
        SalonDTO salon = salonService.getSalonById(id);
        return salon != null ? ResponseEntity.ok(salon) : ResponseEntity.notFound().build();

		
		
       
}
    }