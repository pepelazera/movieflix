package com.movieflix.Mapper;

import com.movieflix.Entity.Movie;
import com.movieflix.Request.MovieRequest;
import com.movieflix.Response.MovieResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest movieRequest) {
        return Movie
                .builder()
                .title(movieRequest.title())
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {
        return MovieResponse
                .builder()
                .id(movie.getMovieId())
                .title(movie.getTitle())
                .build();
    }
}
