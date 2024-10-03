package com.vylee.upload.document.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vylee.upload.document.model.BusinessDocument;
public interface BusinessDocumentRepository extends JpaRepository<BusinessDocument, Long> {
	
}
