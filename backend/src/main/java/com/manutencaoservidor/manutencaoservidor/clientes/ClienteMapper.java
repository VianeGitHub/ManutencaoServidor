package com.manutencaoservidor.manutencaoservidor.clientes;

import com.manutencaoservidor.manutencaoservidor.servidores.ServidorEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public static ClienteEntity toEntity(ClienteRequestDTO dto, ServidorEntity servidor) {
        return ClienteEntity.builder()
                .nomeCliente(dto.getNomeCliente())
                .cnpjCliente(dto.getCnpjCliente())
                .situacaoAtual(dto.getSituacaoAtual())
                .servidor(servidor)
                .build();
    }

    public static ClienteResponseDTO toResponseDTO(ClienteEntity entity) {
        return ClienteResponseDTO.builder()
                .id(entity.getId())
                .nomeCliente(entity.getNomeCliente())
                .cnpjCliente(entity.getCnpjCliente())
                .situacaoAtual(entity.getSituacaoAtual())
                .servidorNome(entity.getServidor().getNomeServidor())
                .build();
    }
}
