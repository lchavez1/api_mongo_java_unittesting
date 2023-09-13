package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repository.IMoviesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MovieServiceTest {

    @Mock
    private IMoviesRepository iMoviesRepository;

    @InjectMocks
    private MovieService movieService;

    private List<Movie> list;
    private String digit;

    private int id;
    private Movie movie;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        list = Arrays.asList(
                new Movie(1, "Harry Potter", "Magic and adventure", 9.99f, 8.8f),
                new Movie(3, "Annabelle", "Horror", 0.9f, 5.4f),
                new Movie(2, "Gran Turismo", "Cars and running", 19.9f, 9.4f));

        digit = "O";

        movie = new Movie(2, "Test 2", "...", 9f, 10f);
        id = 2;
    }

    @Test
    @DisplayName("NotNull")
    void findAllMovies() {
        when(movieService.findAllMovies()).thenReturn(list);
        Assertions.assertNotNull(movieService.findAllMovies());
    }

    @Test
    @DisplayName("FindByDigit")
    void findMovieByDigit() {
        when(movieService.findAllMoviesByDigit(digit)).thenReturn(list);
        Assertions.assertNotNull(movieService.findAllMoviesByDigit(digit));
        Assertions.assertEquals(0, movieService.findAllMoviesByDigit(digit).size());
        if(movieService.findAllMoviesByDigit(digit).size() > 0)
            Assertions.assertEquals(digit, String.valueOf(movieService.findAllMoviesByDigit(digit).get(0).getName().charAt(0)));

    }

    @Test
    @DisplayName("FindById")
    void findMovieById() {
        when(movieService.findMovieById(id)).thenReturn(Optional.ofNullable(movie));
        Assertions.assertEquals(id, movieService.findMovieById(id).get().getId());
    }

    @Test
    @DisplayName("Exist?")
    void existMovie() {
        when(movieService.existMovie(movie.getId())).thenReturn(true);
        Assertions.assertEquals(true, movieService.existMovie(id));
    }

    @Test
    @DisplayName("Create?")
    void createMovie() {
        when(movieService.createMovie(movie)).thenReturn(movie);
        Assertions.assertEquals(2, movieService.createMovie(movie).getId());
        Assertions.assertEquals("Test 2", movieService.createMovie(movie).getName());
    }

}