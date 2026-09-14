package com.movieflix.Response;

import lombok.Builder;

@Builder
public record StreamingResponse(String name, Long id) {
}
