package com.voucher.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voucher.model.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
	Voucher findByCode(String code);
}
