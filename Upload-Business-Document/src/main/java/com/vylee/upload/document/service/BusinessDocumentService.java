package com.vylee.upload.document.service;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import com.vylee.upload.document.model.BusinessDocument;

public interface BusinessDocumentService {
    BusinessDocument uploadDocument(String identityProofType, MultipartFile shopRegistration) throws IOException;
}
