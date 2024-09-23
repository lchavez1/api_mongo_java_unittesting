package com.example.movies.service;

import com.example.movies.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMoviesService {

    Movie createMovie(Movie movie);
    List<Movie> findAllMovies();

    List<Movie> findMovieByQueryParams(String name, String description, Float score, String digit);
    Optional<Movie> findMovieById(Integer id);

    void deleteMovie(Integer id);

    Boolean existMovie(Integer id);


}
