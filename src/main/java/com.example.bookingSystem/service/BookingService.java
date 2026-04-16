package com.example.bookingSystem.service;

import com.example.bookingSystem.model.Booking;

import java.util.List;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getBookingsByUserId(int userId);
    void cancelBooking(int id);
}
