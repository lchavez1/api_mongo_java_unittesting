package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IMoviesRepository extends MongoRepository<Movie, Integer> {
}
