package com.manutencaoservidor.manutencaoservidor.observacoes;

import com.manutencaoservidor.manutencaoservidor.clientes.ClienteEntity;
import com.manutencaoservidor.manutencaoservidor.servidores.ServidorEntity;
import com.manutencaoservidor.manutencaoservidor.usuarios.UsuarioEntity;

public class ObservacaoMapper {

    public static ObservacaoEntity toEntity(ObservacaoRequestDTO dto,
                                            ClienteEntity cliente,
                                            ServidorEntity servidor,
                                            UsuarioEntity usuario) {
        return ObservacaoEntity.builder()
                .descricao(dto.getDescricao())
                .cliente(cliente)
                .servidor(servidor)
                .usuario(usuario)
                .build();
    }

    public static ObservacaoResponseDTO toResponseDTO(ObservacaoEntity entity) {
        return ObservacaoResponseDTO.builder()
                .id(entity.getId())
                .descricao(entity.getDescricao())
                .dataCriacao(entity.getDataCriacao())
                .clienteNome(entity.getCliente() != null ? entity.getCliente().getNomeCliente() : null)
                .servidorNome(entity.getServidor() != null ? entity.getServidor().getNomeServidor() : null)
                .usuarioLogin(entity.getUsuario() != null ? entity.getUsuario().getLoginUsuario() : null)
                .build();
    }
}
