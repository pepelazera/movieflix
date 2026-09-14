package com.movieflix.Mapper;

import com.movieflix.Entity.Category;
import com.movieflix.Request.CategoryRequest;
import com.movieflix.Response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
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
