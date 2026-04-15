package com.example.bookingSystem.controller;

import com.example.bookingSystem.model.Booking;
import com.example.bookingSystem.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingCrud {

    private final BookingService bookingService;

    public BookingCrud (BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> saveBooking(@RequestBody Booking booking) {
        try {
            Booking saved = bookingService.saveBooking(booking);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable int userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable int id) {
        try {
            bookingService.cancelBooking(id);
            return ResponseEntity.ok(Map.of("message", "Booking cancelled"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", e.getMessage()));
        }
    }
}
