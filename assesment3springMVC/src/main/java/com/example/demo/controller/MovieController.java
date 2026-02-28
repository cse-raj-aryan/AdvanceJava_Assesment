package com.example.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@Controller
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/movies")
    public String viewMovies(Model model) {
        List<Movie> movies = service.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/addMovie")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute Movie movie) {
        service.addMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/editMovie/{id}")
    public String showUpdateMovieForm(@PathVariable Long id, Model model) {
        Movie movie = service.getMovieById(id);
        model.addAttribute("movie", movie);
        return "updateMovie";
    }

    @PostMapping("/updateMovie")
    public String updateMovie(@ModelAttribute Movie movie) {
        service.updateMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
        return "redirect:/movies";
    }
}