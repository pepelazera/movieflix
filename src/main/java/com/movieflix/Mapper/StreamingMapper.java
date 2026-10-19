package com.movieflix.Mapper;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import com.movieflix.Entity.Streaming;
import com.movieflix.Request.StreamingRequest;
import com.movieflix.Response.CategoryResponse;
import com.movieflix.Response.MovieResponse;
import com.movieflix.Response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {

        List<Category> categories = streamingRequest.categories().stream()
                .map(id -> Category.builder().categoryId(id).build())
                .toList();

        List<Movie> movies = streamingRequest.streamings().stream()
                .map(id -> Movie.builder().movieId(id).build())
                .toList();

        return Streaming.
                builder()
                .streamingName(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {

        List<CategoryResponse> categoryResponses = streaming.getCategories()
                .stream().map(CategoryMapper::toCategoryResponse)
                .toList();

        List<MovieResponse> movieResponses = streaming.getMovies()
                .stream().map(MovieMapper::toMovieResponse)
                .toList();

        return StreamingResponse
                .builder()
                .id(streaming.getStreamingId())
                .name(streaming.getStreamingName())
                .build();
    }
}
