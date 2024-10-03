package com.vylee.upload.document.ctrl;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.vylee.upload.document.model.BusinessDocument;
import com.vylee.upload.document.service.BusinessDocumentService;

@RestController
@RequestMapping("/api/business-documents")
public class BusinessDocumentController {

    @Autowired
    private BusinessDocumentService businessDocumentService;

    @PostMapping("/upload")
    public ResponseEntity<BusinessDocument> uploadBusinessDocument(
            @RequestParam("identityProofType") String identityProofType,
            @RequestParam("shopRegistration") MultipartFile shopRegistration) {
        try {
            BusinessDocument savedDocument = businessDocumentService.uploadDocument(identityProofType, shopRegistration);
            return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
