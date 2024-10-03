package com.vylee.vendor.services;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vylee.vendor.entity.Vendor_Registration;
import com.vylee.vendor.repository.VendorRepository;
import com.vylee.vendor.util.SendOTPEmail;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private SendOTPEmail sendOTPEmail;

	@Override
	public String loginWithEmail(String to) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);

		String sendMailWithoutAttachment = sendOTPEmail.sendOTPEmail(to, "LOGIN OTP", "Use OTP" +" " +otp + " "
				+ "to log into your VYLEE account. Do not share the OTP or your number with anyone including Vylee personnel.");
		return sendMailWithoutAttachment;
	}

	@Override
	public String vendorRegister(Vendor_Registration registration) {
		// TODO Auto-generated method stub
		Vendor_Registration vendorRegister = vendorRepository.save(registration);

		if (vendorRegister != null) {

			return "REGISTRATION SUCCESSFULLY..!!";

		} else {
			return "SOMETHING WENT WRONG";
		}

	}

	@Override
	public Vendor_Registration findVendorViaMobile(Integer vendorMobile) {
		// TODO Auto-generated method stub

		Vendor_Registration findByMobileNumber = vendorRepository.findByMobileNumber(vendorMobile);

		if (findByMobileNumber != null) {
			return findByMobileNumber;

		} else {
			return null;
		}
	}

	@Override
	public String addVendorAddress(Vendor_Registration registration, Integer vendorId) {
		// TODO Auto-generated method stub
		Vendor_Registration vendor_Registration = null;
		Vendor_Registration addressUpdate = null;
		Optional<Vendor_Registration> vendorWithId = vendorRepository.findById(vendorId);
		if (vendorWithId.isPresent()) {
			vendor_Registration = vendorWithId.get();
			vendor_Registration.setVendorAddress(registration.getVendorAddress());
			vendor_Registration.setVendorCountry(registration.getVendorCountry());
			vendor_Registration.setVendorState(registration.getVendorState());
			vendor_Registration.setVensorCity(registration.getVensorCity());
			vendor_Registration.setPincode(registration.getPincode());

			addressUpdate = vendorRepository.save(vendor_Registration);
			if (addressUpdate != null) {

				return "Address Update successfully...!!";

			} else {
				return "Something went wrong...!!!";
			}
		} else {
			return "Vendor ID not match...!!";
		}

	}

}
