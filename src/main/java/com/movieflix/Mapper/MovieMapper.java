package com.movieflix.Mapper;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import com.movieflix.Entity.Streaming;
import com.movieflix.Request.MovieRequest;
import com.movieflix.Response.CategoryResponse;
import com.movieflix.Response.MovieResponse;
import com.movieflix.Response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest movieRequest) {

        List<Category> category = movieRequest.categories().stream()
                .map(id -> Category.builder().categoryId(id).build())
                .toList();

        List<Streaming> streaming = movieRequest.categories().stream()
                .map(id -> Streaming.builder().streamingId(id).build())
                .toList();

        return Movie
                .builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .categories(category)
                .streamings(streaming)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categoryResponses = movie.getCategories()
                .stream().map(CategoryMapper::toCategoryResponse)
                .toList();

        List<StreamingResponse> streamingResponses = movie.getStreamings()
                .stream().map(StreamingMapper::toStreamingResponse)
                .toList();

        return MovieResponse.builder()
                .id(movie.getMovieId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categoryResponses)
                .streaming(streamingResponses)
                .build();
    }
}
