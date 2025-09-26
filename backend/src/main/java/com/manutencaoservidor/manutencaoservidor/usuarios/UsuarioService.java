package com.manutencaoservidor.manutencaoservidor.usuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        if(usuarioRepository.existsByLoginUsuario(dto.getLoginUsuario())) {
            throw new IllegalArgumentException("Login já cadastrado");
        }
        UsuarioEntity usuario = UsuarioMapper.toEntity(dto);
        UsuarioEntity salvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDTO(salvo);
    }

    private List<UsuarioResponseDTO> listarTodosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toResponseDTO)
                .toList();
    }
}
