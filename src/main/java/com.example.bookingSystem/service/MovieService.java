package com.example.bookingSystem.service;

import com.example.bookingSystem.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(int id);
    Movie saveMovie(Movie movie);
    void deleteMovie(int id);
}
