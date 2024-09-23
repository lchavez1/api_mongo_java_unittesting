package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface IMoviesRepository extends MongoRepository<Movie, Integer> {

    List<Movie> findByDescriptionLike(String name);

    @Query("{ 'name' : ?0 }")
    List<Movie> findByTheMovieName(String name);

    List<Movie> findByScoreGreaterThan(Float score);
}
