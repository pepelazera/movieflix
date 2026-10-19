package com.movieflix.Response;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import lombok.Builder;

import java.util.List;

@Builder
public record StreamingResponse(String name,
                                Long id,
                                List<CategoryResponse> categories,
                                List<MovieResponse> movies
                                ) {
}
