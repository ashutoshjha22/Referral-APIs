package com.vylee.upload.document.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.vylee.upload.document.model.BusinessDocument;
import com.vylee.upload.document.repo.BusinessDocumentRepository;
import com.vylee.upload.document.service.BusinessDocumentService;

@Service
public class BusinessDocumentServiceImpl implements BusinessDocumentService {

    @Autowired
    private BusinessDocumentRepository businessDocumentRepository;

    @Override
    public BusinessDocument uploadDocument(String identityProofType, MultipartFile shopRegistration) throws IOException {
        String fileName = StringUtils.cleanPath(shopRegistration.getOriginalFilename());
        String fileStorageLocation = "C:\\Users\\dell\\OneDrive\\Desktop\\images\\"; 
        
        java.nio.file.Path targetLocation = Paths.get(fileStorageLocation).resolve(fileName);
        Files.copy(shopRegistration.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        BusinessDocument businessDocument = new BusinessDocument();
        businessDocument.setIdentityProofType(identityProofType);
        businessDocument.setShopRegistrationFilePath(targetLocation.toString());

        return businessDocumentRepository.save(businessDocument);
    }
}
