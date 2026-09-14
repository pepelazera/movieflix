package com.movieflix.Response;

import lombok.Builder;

@Builder
public record MovieResponse(String title, Long id) {
}
