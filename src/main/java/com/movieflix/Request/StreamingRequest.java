package com.movieflix.Request;

import lombok.Builder;

import java.util.List;

@Builder
public record StreamingRequest(String name,
                                List<Long> categories,
                                List<Long> streamings
    ) {
    // Cria o request que vai receber o nome. Essa parte vai ser dentro do próprio Mapper
}
