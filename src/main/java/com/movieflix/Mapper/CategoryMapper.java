package com.movieflix.Mapper;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import com.movieflix.Entity.Streaming;
import com.movieflix.Request.CategoryRequest;
import com.movieflix.Response.CategoryResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {

       List<Movie> movies = categoryRequest.movies().stream()
               .map(id -> Movie.builder().movieId(id).build())
               .toList();       

        return Category
                .builder()
                .categoryName(categoryRequest.name()) // Aqui, ele só vai receber o name pq o id é passado automaticamente
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getCategoryId())
                .name(category.getCategoryName())
                .build();
        // Já nesse caso, recebe o id pois o CategoryResponse está falando da resposta que teremos, e nela nós recebemos tanto o id quanto o nome
    }
}
