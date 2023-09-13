package com.example.movies.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Movies")
public class Movie {
    @Id
    private int id;
    private String name;
    private String description;
    private Float price;
    private Float score;

    public Movie(int id, String name, String description, Float price, Float score){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.score = score;
    }
}
