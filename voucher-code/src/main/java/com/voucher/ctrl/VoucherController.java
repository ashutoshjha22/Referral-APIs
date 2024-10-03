package com.voucher.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voucher.model.Voucher;
import com.voucher.service.VoucherService;
import com.voucher.serviceImpl.VoucherServiceImpl;

@RestController
@RequestMapping("/api/vouchers")
public class VoucherController {

	@Autowired
	private VoucherService voucherService;

	@Autowired
	private VoucherServiceImpl voucherServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<Voucher> createVoucher(@RequestParam String description, @RequestParam double discount) {
		String code = voucherServiceImpl.generateVoucherCode();
		Voucher voucher = voucherService.createVoucher(code, description, discount);
		return ResponseEntity.ok(voucher);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Voucher>> getAllVouchers() {
		List<Voucher> vouchers = voucherService.getAllVouchers();
		return ResponseEntity.ok(vouchers);
	}

	@GetMapping("/{code}")
	public ResponseEntity<Voucher> getVoucherByCode(@PathVariable String code) {
		Voucher voucher = voucherService.getVoucherByCode(code);
		return ResponseEntity.ok(voucher);
	}
}
