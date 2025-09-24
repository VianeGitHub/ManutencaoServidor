package com.manutencaoservidor.manutencaoservidor.clientes;

import com.manutencaoservidor.manutencaoservidor.enums.SituacaoAtual;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRequestDTO {
    private String nomeCliente;
    private String cnpjCliente;
    private SituacaoAtual situacaoAtual;
    private Long servidorId;
}
