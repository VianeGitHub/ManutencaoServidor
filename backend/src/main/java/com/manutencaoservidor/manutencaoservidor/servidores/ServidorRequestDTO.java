package com.manutencaoservidor.manutencaoservidor.servidores;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServidorRequestDTO {
    @NotBlank
    private String nomeServidor;

    @Pattern(regexp = "^\\\\d{1,3}(\\\\.\\\\d{1,3}){3}\\$\", message = \"IP inválido")
    private String ipServidor;
}
