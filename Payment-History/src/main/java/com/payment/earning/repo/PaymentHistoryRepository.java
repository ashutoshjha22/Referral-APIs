package com.payment.earning.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.earning.model.PaymentHistory;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
	Optional<PaymentHistory> findById(Integer vendor_id);

}
