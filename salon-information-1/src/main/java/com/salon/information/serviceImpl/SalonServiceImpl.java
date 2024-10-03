package com.salon.information.serviceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.salon.information.dto.SalonDTO;
import com.salon.information.model.Salon;
import com.salon.information.repo.SalonRepository;
import com.salon.information.service.SalonService;

@Service
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    private final Path fileStoragePath = Paths.get("/path/to/your/uploads");

    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public SalonDTO createSalon(SalonDTO salonDTO, MultipartFile logoFile) {
        Salon salon = new Salon();
        salon.setDescription(salonDTO.getDescription());
        salon.setWebsite(salonDTO.getWebsite());
        salon.setWhatsappNumber(salonDTO.getWhatsappNumber());

        // Handle file upload
        if (logoFile != null && !logoFile.isEmpty()) {
            String logoFileName = saveLogoFile(logoFile);
            salon.setLogoFileName(logoFileName);
        }

        Salon savedSalon = salonRepository.save(salon);
        return convertToDTO(savedSalon);
    }

    @Override
    public SalonDTO getSalonById(Long id) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salon not found with id: " + id));
        return convertToDTO(salon);
    }

    @Override
    public List<SalonDTO> getAllSalons() {
        return salonRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalonDTO updateSalon(Long id, SalonDTO salonDTO, MultipartFile logoFile) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salon not found with id: " + id));

        salon.setDescription(salonDTO.getDescription());
        salon.setWebsite(salonDTO.getWebsite());
        salon.setWhatsappNumber(salonDTO.getWhatsappNumber());

        // Handle logo file update
        if (logoFile != null && !logoFile.isEmpty()) {
            String logoFileName = saveLogoFile(logoFile);
            salon.setLogoFileName(logoFileName);
        }

        Salon updatedSalon = salonRepository.save(salon);
        return convertToDTO(updatedSalon);
    }

    @Override
    public void deleteSalon(Long id) {
        Salon salon = salonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salon not found with id: " + id));
        salonRepository.delete(salon);
    }

    // Helper method to handle file storage
    private String saveLogoFile(MultipartFile logoFile) {
        try {
            String fileName = logoFile.getOriginalFilename();
            Path targetLocation = fileStoragePath.resolve(fileName);
            Files.copy(logoFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Could not store file: " + logoFile.getOriginalFilename(), e);
        }
    }

    private SalonDTO convertToDTO(Salon salon) {
        SalonDTO dto = new SalonDTO();
        dto.setDescription(salon.getDescription());
        dto.setWebsite(salon.getWebsite());
        dto.setWhatsappNumber(salon.getWhatsappNumber());
        dto.setLogoFileName(salon.getLogoFileName());
        return dto;
    }
}
