package com.movieflix.Request;

import com.movieflix.Entity.Movie;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryRequest(@NotEmpty(message = "Nome da categoria é obrigatório") String name) {
}
