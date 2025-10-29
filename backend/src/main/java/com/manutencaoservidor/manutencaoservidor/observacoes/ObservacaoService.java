package com.manutencaoservidor.manutencaoservidor.observacoes;

import com.manutencaoservidor.manutencaoservidor.clientes.ClienteEntity;
import com.manutencaoservidor.manutencaoservidor.clientes.ClienteRepository;
import com.manutencaoservidor.manutencaoservidor.servidores.ServidorEntity;
import com.manutencaoservidor.manutencaoservidor.servidores.ServidorRepository;
import com.manutencaoservidor.manutencaoservidor.usuarios.UsuarioEntity;
import com.manutencaoservidor.manutencaoservidor.usuarios.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObservacaoService {

    private final ObservacaoRepository observacaoRepository;
    private final ClienteRepository clienteRepository;
    private final ServidorRepository servidorRepository;
    private final UsuarioRepository usuarioRepository;

    public ObservacaoResponseDTO criarObservacao(ObservacaoRequestDTO dto) {
        ClienteEntity cliente = null;
        ServidorEntity servidor = null;
        UsuarioEntity usuario = null;

        if (dto.getIdCliente() != null) {
            cliente = clienteRepository.findById(dto.getIdCliente())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        }

        if (dto.getIdServidor() != null) {
            servidor = servidorRepository.findById(dto.getIdServidor())
                    .orElseThrow(() -> new EntityNotFoundException("Servidor não encontrado"));
        }

        if (dto.getIdUsuario() != null) {
            usuario = usuarioRepository.findById(dto.getIdUsuario())
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        }

        ObservacaoEntity observacao = ObservacaoMapper.toEntity(dto, cliente, servidor, usuario);
        ObservacaoEntity salva = observacaoRepository.save(observacao);

        return ObservacaoMapper.toResponseDTO(salva);
    }

    public List<ObservacaoResponseDTO> listarTodas() {
        return observacaoRepository.findAll()
                .stream()
                .map(ObservacaoMapper::toResponseDTO)
                .toList();
    }

    public ObservacaoResponseDTO buscarPorId(Long id) {
        ObservacaoEntity entity = observacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Observação não encontrada"));
        return ObservacaoMapper.toResponseDTO(entity);
    }

    public void deletarObservacao(Long id) {
        if (!observacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Observação não encontrada");
        }
        observacaoRepository.deleteById(id);
    }
}
