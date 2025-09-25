package com.manutencaoservidor.manutencaoservidor.servidores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServidorResponseDTO {
    private Long id;
    private String nomeServidor;
    private String ipServidor;
}
