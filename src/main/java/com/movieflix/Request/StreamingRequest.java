package com.movieflix.Request;

import lombok.Builder;

@Builder
public record StreamingRequest(String name) {
    // Cria o request que vai receber o nome. Essa parte vai ser dentro do próprio Mapper
}
