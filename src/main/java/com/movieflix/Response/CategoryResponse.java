package com.movieflix.Response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
    // Importante passar os parâmetros que vamos utilizar, pois eles que serão instanciados lá no CategoryMapper
}
