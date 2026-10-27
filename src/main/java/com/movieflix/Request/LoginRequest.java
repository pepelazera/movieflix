package com.movieflix.Request;

import lombok.Builder;

@Builder
public record LoginRequest(String email, String password) {
}
