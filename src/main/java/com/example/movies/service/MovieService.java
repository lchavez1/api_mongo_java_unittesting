package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMoviesService{

    @Autowired
    IMoviesRepository iMoviesRepository;
    @Override
    public Movie createMovie(Movie movie) {
        return iMoviesRepository.save(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
        return iMoviesRepository.findAll();
    }

    @Override
    public List<Movie> findAllMoviesByDigit(String digit) {
        return iMoviesRepository.findAll().stream().filter(movie -> movie.getName().startsWith(digit)).toList();
    }

    @Override
    public Optional<Movie> findMovieById(Integer id) {
        return iMoviesRepository.findById(id);
    }

    @Override
    public void deleteMovie(Integer id) {
        iMoviesRepository.deleteById(id);
    }
    @Override
    public Boolean existMovie(Integer id){
        return iMoviesRepository.existsById(id);
    }
}
