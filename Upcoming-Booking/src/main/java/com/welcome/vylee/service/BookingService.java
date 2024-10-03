package com.welcome.vylee.service;

import java.util.List;

import com.welcome.vylee.model.Booking;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking updateBooking(Long id, Booking bookingDetails);
    void deleteBooking(Long id);
}
