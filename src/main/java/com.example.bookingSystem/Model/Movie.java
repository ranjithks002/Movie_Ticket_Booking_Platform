package com.example.bookingSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String genre;
    private String language;
    private String duration;
    private String rating;
    private String cert;
    private String poster;
    @Column(name = "description", length = 1000)
    private String desc;
    private int price;
    private String status;


    public int getId()          { return id; }
    public String getTitle()    { return title; }
    public String getGenre()    { return genre; }
    public String getLanguage() { return language; }
    public String getDuration() { return duration; }
    public String getRating()   { return rating; }
    public String getCert()     { return cert; }
    public String getPoster()   { return poster; }
    public String getDesc()     { return desc; }
    public int getPrice()       { return price; }
    public String getStatus()   { return status; }


    public void setId(int id)                { this.id = id; }
    public void setTitle(String title)       { this.title = title; }
    public void setGenre(String genre)       { this.genre = genre; }
    public void setLanguage(String language) { this.language = language; }
    public void setDuration(String duration) { this.duration = duration; }
    public void setRating(String rating)     { this.rating = rating; }
    public void setCert(String cert)         { this.cert = cert; }
    public void setPoster(String poster)     { this.poster = poster; }
    public void setDesc(String desc)         { this.desc = desc; }
    public void setPrice(int price)          { this.price = price; }
    public void setStatus(String status)     { this.status = status; }

}
