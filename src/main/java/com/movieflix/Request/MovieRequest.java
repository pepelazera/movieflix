package com.movieflix.Request;

import lombok.Builder;

@Builder
public record MovieRequest(String title) {
}
