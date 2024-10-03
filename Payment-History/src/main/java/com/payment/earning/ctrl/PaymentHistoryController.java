package com.payment.earning.ctrl;


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

import com.payment.earning.model.PaymentHistory;
import com.payment.earning.service.PaymentHistoryService;

@RestController
@RequestMapping("/api/payments")
public class PaymentHistoryController {

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @GetMapping
    public List<PaymentHistory> getAllPayments() {
        return paymentHistoryService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentHistory> getPaymentById(@PathVariable Long id) {
        PaymentHistory paymentHistory = paymentHistoryService.getPaymentById(id);
        return ResponseEntity.ok(paymentHistory);
    }

    @PostMapping
    public ResponseEntity<PaymentHistory> createPayment(@RequestBody PaymentHistory paymentHistory) {
        PaymentHistory createdPayment = paymentHistoryService.createPayment(paymentHistory);
        return ResponseEntity.ok(createdPayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentHistory> updatePayment(@PathVariable Long id, @RequestBody PaymentHistory paymentHistory) {
        PaymentHistory updatedPayment = paymentHistoryService.updatePayment(id, paymentHistory);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
    	 paymentHistoryService.deletePayment(id);
         return ResponseEntity.noContent().build();
     }
 }