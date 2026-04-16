package com.example.bookingSystem.service;

import com.example.bookingSystem.model.Booking;
import com.example.bookingSystem.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) { return bookingRepository.save(booking); }
    public List<Booking> getBookingsByUserId(int userId) { return bookingRepository.findByUserId(userId); }
    public void cancelBooking(int id) { bookingRepository.deleteById(id); }
}
