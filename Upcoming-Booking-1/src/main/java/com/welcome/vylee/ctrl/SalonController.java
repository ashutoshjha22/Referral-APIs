package com.welcome.vylee.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.vylee.model.Salon;
import com.welcome.vylee.service.SalonService;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @PostMapping
    public Salon createSalon(@RequestBody Salon salon) {
        return salonService.saveSalon(salon);
    }

    @GetMapping
    public List<Salon> getAllSalons() {
        return salonService.getAllSalons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salon> getSalonById(@PathVariable Long id) {
        Salon salon = salonService.getSalonById(id);
        return ResponseEntity.ok(salon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salon> updateSalon(@PathVariable Long id, @RequestBody Salon salonDetails) {
        Salon updatedSalon = salonService.updateSalon(id, salonDetails);
        return ResponseEntity.ok(updatedSalon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable Long id) {
        salonService.deleteSalon(id);
        return ResponseEntity.noContent().build();
    }
}
