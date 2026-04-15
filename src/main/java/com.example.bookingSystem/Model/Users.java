package com.example.bookingSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;

    public void setId (int id) { this.id = id; }
    public void setFullName (String fullName) { this.fullName = fullName; }
    public void setEmail (String email) { this.email = email; }
    public void setPhoneNumber (String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setPassword (String password) { this.password = password; }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return  email; }
    public String getPhoneNumber() {return phoneNumber; }
    public String getPassword() {return password; }
}
