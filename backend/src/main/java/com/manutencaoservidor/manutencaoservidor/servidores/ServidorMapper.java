package com.manutencaoservidor.manutencaoservidor.servidores;

public class ServidorMapper {
    public static ServidorEntity toEntity(ServidorRequestDTO dto) {
        return ServidorEntity.builder()
                .nomeServidor(dto.getNomeServidor())
                .ipServidor(dto.getIpServidor())
                .build();
    }

    public static ServidorResponseDTO toResponseDTO(ServidorEntity entity) {
        return ServidorResponseDTO.builder()
                .id(entity.getId())
                .nomeServidor(entity.getNomeServidor())
                .ipServidor(entity.getIpServidor())
                .build();
    }
}
