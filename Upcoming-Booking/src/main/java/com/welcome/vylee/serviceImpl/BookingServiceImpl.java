package com.welcome.vylee.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welcome.vylee.Exception.ResourceNotFoundException;
import com.welcome.vylee.model.Booking;
import com.welcome.vylee.repo.BookingRepository;
import com.welcome.vylee.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow();

        booking.setServiceName(bookingDetails.getServiceName());
        booking.setSalon(bookingDetails.getSalon());
        booking.setBookingDate(bookingDetails.getBookingDate());
        booking.setCustomerName(bookingDetails.getCustomerName());
        booking.setCustomerNotes(bookingDetails.getCustomerNotes());

        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        bookingRepository.delete(booking);
    }
}
