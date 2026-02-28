package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void updateMovie(Movie movie) {
        repository.save(movie);
    }

    public void deleteMovie(Long id) {
        repository.deleteById(id);
    }
}