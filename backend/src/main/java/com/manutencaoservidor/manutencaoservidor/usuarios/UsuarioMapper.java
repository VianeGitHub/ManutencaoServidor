package com.manutencaoservidor.manutencaoservidor.usuarios;

public class UsuarioMapper {

    public static UsuarioEntity toEntity(UsuarioRequestDTO dto) {
        return UsuarioEntity.builder()
                .loginUsuario(dto.getLoginUsuario())
                .senhaUsuario(dto.getSenhaUsuario())
                .build();
    }

    public static UsuarioResponseDTO toResponseDTO(UsuarioEntity entity) {
        return UsuarioResponseDTO.builder()
                .id(entity.getId())
                .loginUsuario(entity.getLoginUsuario())
                .build();
    }
}
