package com.movieflix.Request;

import com.movieflix.Entity.Movie;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryRequest(String name) {
}
