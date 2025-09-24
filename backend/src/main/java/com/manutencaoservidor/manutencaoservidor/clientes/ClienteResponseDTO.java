package com.manutencaoservidor.manutencaoservidor.clientes;

import com.manutencaoservidor.manutencaoservidor.enums.SituacaoAtual;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponseDTO {
    private Long id;
    private String nomeCliente;
    private String cnpjCliente;
    private SituacaoAtual situacaoAtual;
    private String servidorNome;
}
