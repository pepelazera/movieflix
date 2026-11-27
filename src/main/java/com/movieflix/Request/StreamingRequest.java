package com.movieflix.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

@Builder
public record StreamingRequest(@NotEmpty(message = "Nome do serviço de streaming é obrigatório") String name) {
    // Cria o request que vai receber o nome. Essa parte vai ser dentro do próprio Mapper
}
