package com.example.bookingSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int movieId;
    private String movieTitle;
    private String bookingDate;
    private String showTime;
    private String seats;
    private int totalAmount;
    private String bookingRef;

    public int getId()              { return id; }
    public int getUserId()          { return userId; }
    public int getMovieId()         { return movieId; }
    public String getMovieTitle()   { return movieTitle; }
    public String getBookingDate()  { return bookingDate; }
    public String getShowTime()     { return showTime; }
    public String getSeats()        { return seats; }
    public int getTotalAmount()     { return totalAmount; }
    public String getBookingRef()   { return bookingRef; }

    public void setId(int id)                        { this.id = id; }
    public void setUserId(int userId)                { this.userId = userId; }
    public void setMovieId(int movieId)              { this.movieId = movieId; }
    public void setMovieTitle(String movieTitle)     { this.movieTitle = movieTitle; }
    public void setBookingDate(String bookingDate)   { this.bookingDate = bookingDate; }
    public void setShowTime(String showTime)         { this.showTime = showTime; }
    public void setSeats(String seats)               { this.seats = seats; }
    public void setTotalAmount(int totalAmount)      { this.totalAmount = totalAmount; }
    public void setBookingRef(String bookingRef)     { this.bookingRef = bookingRef; }
}
