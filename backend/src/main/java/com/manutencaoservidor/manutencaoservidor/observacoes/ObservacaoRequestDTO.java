package com.manutencaoservidor.manutencaoservidor.observacoes;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservacaoRequestDTO {
    private String descricao;
    private Long idCliente;  // opcional
    private Long idServidor; // opcional
    private Long idUsuario;  // quem fez a observação
}
