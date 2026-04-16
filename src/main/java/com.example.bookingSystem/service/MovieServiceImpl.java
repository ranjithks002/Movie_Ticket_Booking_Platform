package com.example.bookingSystem.service;

import com.example.bookingSystem.model.Movie;
import com.example.bookingSystem.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> getAllMovies()           { return movieRepository.findAll(); }
    public Optional<Movie> getMovieById(int id){ return movieRepository.findById(id); }
    public Movie saveMovie(Movie movie)         { return movieRepository.save(movie); }
    public void deleteMovie(int id)            { movieRepository.deleteById(id); }
}
