package com.github.fabriciolfj.movidesource.api.dto;

import com.github.fabriciolfj.movidesource.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieRequest {

    String action;
    Iterable<Movie> movies;
    LocalDateTime created;
}
