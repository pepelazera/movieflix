package com.movieflix.Request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name) {
}
