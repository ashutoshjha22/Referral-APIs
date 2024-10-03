package com.voucher.serviceImpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voucher.model.Voucher;
import com.voucher.repo.VoucherRepository;
import com.voucher.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {

	@Autowired
	private VoucherRepository voucherRepository;

	@Override
	public Voucher createVoucher(String code, String description, double discount) {
		Voucher voucher = new Voucher(code, description, discount);
		return voucherRepository.save(voucher);
	}

	@Override
	public List<Voucher> getAllVouchers() {
		return voucherRepository.findAll();
	}

	@Override
	public Voucher getVoucherByCode(String code) {
		return voucherRepository.findByCode(code);
	}

	public String generateVoucherCode() {
		// Generate a random voucher code
		String characters = "ABCDEFGHIJKLMNOPQXYZ0123456789RSTUVW";
		Random random = new Random();
		StringBuilder code = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			code.append(characters.charAt(random.nextInt(characters.length())));
		}
		return code.toString();
	}
}
