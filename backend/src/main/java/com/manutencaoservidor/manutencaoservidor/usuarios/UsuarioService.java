package com.manutencaoservidor.manutencaoservidor.usuarios;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByLoginUsuario(dto.getLoginUsuario())) {
            throw new IllegalArgumentException("Login já cadastrado");
        }

        UsuarioEntity usuario = UsuarioMapper.toEntity(dto);
        UsuarioEntity salvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDTO(salvo);
    }

    public List<UsuarioResponseDTO> listarTodosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarUsuarioPorId(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return UsuarioMapper.toResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        usuario.setLoginUsuario(dto.getLoginUsuario());
        usuario.setSenhaUsuario(dto.getSenhaUsuario());

        UsuarioEntity atualizado = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDTO(atualizado);
    }

    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
