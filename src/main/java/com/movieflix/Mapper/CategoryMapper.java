package com.movieflix.Mapper;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import com.movieflix.Entity.Streaming;
import com.movieflix.Request.CategoryRequest;
import com.movieflix.Response.CategoryResponse;
import com.movieflix.Response.MovieResponse;
import com.movieflix.Response.StreamingResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

import java.util.List;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {

        List<Movie> movies = categoryRequest.movies().stream()
                .map(id -> Movie.builder().movieId(id).build())
                .toList();

        List<Streaming> streamings = categoryRequest.streamings().stream()
                .map(id -> Streaming.builder().streamingId(id).build())
                .toList();

        return Category
                .builder()
                .categoryName(categoryRequest.name()) // Aqui, ele só vai receber o name pq o id é passado automaticamente
                .movies(movies)
                .streamings(streamings)
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {

        List<MovieResponse> movieResponses = category.getMovies()
                .stream().map(MovieMapper::toMovieResponse)
                .toList();

        List<StreamingResponse> streamingResponses = category.getStreamings()
                .stream().map(StreamingMapper::toStreamingResponse)
                .toList();

        return CategoryResponse
                .builder()
                .id(category.getCategoryId())
                .name(category.getCategoryName())
                .build();
        // Já nesse caso, recebe o id pois o CategoryResponse está falando da resposta que teremos, e nela nós recebemos tanto o id quanto o nome
    }
}
