package com.manutencaoservidor.manutencaoservidor.observacoes;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservacaoResponseDTO {
    private Long id;
    private String descricao;
    private LocalDateTime dataCriacao;
    private String clienteNome;
    private String servidorNome;
    private String usuarioLogin;
}
