package com.github.fabriciolfj.movideprocessor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {

    private String id;
    private String title;
    private String actor;
    private int year;
    private String genre;
    private int starts;
    private MovieImdb imdb;
}
