package com.movieflix.Request;

import lombok.Builder;

@Builder
public record UserRequest(String name,
                          String email,
                          String password) {
}
