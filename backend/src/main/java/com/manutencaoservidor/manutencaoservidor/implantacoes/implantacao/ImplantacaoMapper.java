package com.manutencaoservidor.manutencaoservidor.implantacoes.implantacao;

import com.manutencaoservidor.manutencaoservidor.usuarios.UsuarioEntity;

public class ImplantacaoMapper {

    public static ImplantacaoEntity toEntity(ImplantacaoRequestDTO dto, UsuarioEntity usuario) {
        return ImplantacaoEntity.builder()
                .dataImplantacao(dto.getDataImplantacao())
                .horaImplantacao(dto.getHoraImplantacao())
                .duracao(dto.getDuracao())
                .status(dto.getStatus())
                .tecnico(dto.getTecnico())
                .tipoImplantacao(dto.getTipoImplantacao())
                .contato(dto.getContato())
                .cliente(dto.getCliente())
                .usuario(usuario)
                .build();
    }

    public static ImplantacaoResponseDTO toResponseDTO(ImplantacaoEntity entity) {
        return ImplantacaoResponseDTO.builder()
                .id(entity.getId())
                .dataImplantacao(entity.getDataImplantacao())
                .horaImplantacao(entity.getHoraImplantacao())
                .duracao(entity.getDuracao())
                .status(entity.getStatus())
                .tecnico(entity.getTecnico())
                .tipoImplantacao(entity.getTipoImplantacao())
                .contato(entity.getContato())
                .cliente(entity.getCliente())
                .usuarioResponsavel(entity.getUsuario().getLoginUsuario())
                .build();
    }
}
