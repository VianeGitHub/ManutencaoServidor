package com.manutencaoservidor.manutencaoservidor.servidores;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServidorService {

    private final ServidorRepository servidorRepository;

    public ServidorResponseDTO criarServidor(ServidorRequestDTO dto) {
        if (servidorRepository.existsByNomeServidor(dto.getNomeServidor())) {
            throw new IllegalArgumentException("Servidor já cadastrado");
        }
        ServidorEntity servidor = ServidorMapper.toEntity(dto);
        ServidorEntity salvo = servidorRepository.save(servidor);
        return ServidorMapper.toResponseDTO(salvo);
    }

    public List<ServidorResponseDTO> listarTodosServidores() {
        return servidorRepository.findAll()
                .stream()
                .map(ServidorMapper::toResponseDTO)
                .toList();
    }

    public ServidorResponseDTO buscarServidorPorId(Long id) {
        ServidorEntity servidor = servidorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servidor não encontrado"));
        return ServidorMapper.toResponseDTO(servidor);
    }

    public ServidorResponseDTO atualizarServidor(Long id, ServidorRequestDTO dto) {
        ServidorEntity servidor = servidorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servidor não encontrado"));

        servidor.setNomeServidor(dto.getNomeServidor());
        servidor.setIpServidor(dto.getIpServidor());

        ServidorEntity atualizado = servidorRepository.save(servidor);
        return ServidorMapper.toResponseDTO(atualizado);
    }

    public void deletarServidor(Long id) {
        if(!servidorRepository.existsById(id)) {
            throw new EntityNotFoundException("Servidor não encontrado");
        }
        servidorRepository.deleteById(id);
    }
}
