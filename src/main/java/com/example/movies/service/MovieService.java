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
    public List<Movie> findMovieByQueryParams(String name, String description, Float score, String digit) {
        if (name != null) {
            return findMoviesByName(name);
        } else if (description != null) {
            return findByMoviesDescription(description);
        } else if (score != null) {
            return findMoviesByScoreGreaterThan8(score);
        } else if (digit != null) {
            return findAllMoviesByDigit(digit);
        } else {
            return findAllMovies();
        }
    }

    private List<Movie> findByMoviesDescription(String description) {
        return iMoviesRepository.findByDescriptionLike(description);
    }

    public List<Movie> findMoviesByName(String name) {
        return iMoviesRepository.findByTheMovieName(name);
    }


    private List<Movie> findMoviesByScoreGreaterThan8(Float score) {
        return iMoviesRepository.findByScoreGreaterThan(score);
    }

    // find movies that starts with any digit
    private List<Movie> findAllMoviesByDigit(String digit) {
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
