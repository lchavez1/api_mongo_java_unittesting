package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "Movies")
public class Movie {
    @Id
    private int id;
    private String name;
    private String description;
    private Float price;
    private Float score;
}


