package com.voucher.service;

import java.util.List;

import com.voucher.model.Voucher;

public interface VoucherService {
	Voucher createVoucher(String code, String description, double discount);

	List<Voucher> getAllVouchers();

	Voucher getVoucherByCode(String code);
}
