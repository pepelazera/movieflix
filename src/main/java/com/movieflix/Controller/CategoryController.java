package com.movieflix.Controller;

import com.movieflix.Entity.Category;
import com.movieflix.Mapper.CategoryMapper;
import com.movieflix.Request.CategoryRequest;
import com.movieflix.Response.CategoryResponse;
import com.movieflix.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> searchAllCategories() {
        List<CategoryResponse> categories = categoryService.searchCategories()
                .stream()
                .map((CategoryMapper::toCategoryResponse))
                .toList();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> searchCategoryById(@PathVariable  Long id) {
        return categoryService.searchCategoryById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategories(@RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {

        if (categoryService.searchCategoryById(id).isPresent()) {
            categoryService.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
