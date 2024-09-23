package com.example.movies.controller;

import com.example.movies.model.Movie;
import com.example.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/")
    public ResponseEntity<?> createMovie(@RequestBody Movie movie) {
        movieService.createMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllMovies() {
        List<Movie> list = movieService.findAllMovies();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findMovieById(@PathVariable Integer id) {
        Optional<Movie> movie = movieService.findMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<?> existMovie(@PathVariable Integer id) {
        Boolean response = movieService.existMovie(id);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/query")
    public List<Movie> findByDescription(@RequestParam(name = "name", required = false) String name,
                                         @RequestParam(name = "description", required = false) String description,
                                         @RequestParam(name = "score", required = false) Float score,
                                         @RequestParam(name = "startsWith", required = false) String digit) {
        return movieService.findMovieByQueryParams(name, description, score, digit);
    }
}
