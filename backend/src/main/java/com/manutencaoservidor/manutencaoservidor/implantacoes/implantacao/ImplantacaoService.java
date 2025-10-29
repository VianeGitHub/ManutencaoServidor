package com.manutencaoservidor.manutencaoservidor.implantacoes.implantacao;

import com.manutencaoservidor.manutencaoservidor.usuarios.UsuarioEntity;
import com.manutencaoservidor.manutencaoservidor.usuarios.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplantacaoService {

    private final ImplantacaoRepository implantacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public ImplantacaoResponseDTO criarImplantacao(ImplantacaoRequestDTO dto) {
        UsuarioEntity usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        ImplantacaoEntity entity = ImplantacaoMapper.toEntity(dto, usuario);
        ImplantacaoEntity salvo = implantacaoRepository.save(entity);

        return ImplantacaoMapper.toResponseDTO(salvo);
    }

    public List<ImplantacaoResponseDTO> listarTodas() {
        return implantacaoRepository.findAll()
                .stream()
                .map(ImplantacaoMapper::toResponseDTO)
                .toList();
    }

    public ImplantacaoResponseDTO buscarPorId(Long id) {
        ImplantacaoEntity implantacao = implantacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Implantação não encontrada"));
        return ImplantacaoMapper.toResponseDTO(implantacao);
    }

    public ImplantacaoResponseDTO atualizarImplantacao(Long id, ImplantacaoRequestDTO dto) {
        ImplantacaoEntity implantacao = implantacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Implantação não encontrada"));

        UsuarioEntity usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        implantacao.setDataImplantacao(dto.getDataImplantacao());
        implantacao.setHoraImplantacao(dto.getHoraImplantacao());
        implantacao.setDuracao(dto.getDuracao());
        implantacao.setStatus(dto.getStatus());
        implantacao.setTecnico(dto.getTecnico());
        implantacao.setTipoImplantacao(dto.getTipoImplantacao());
        implantacao.setContato(dto.getContato());
        implantacao.setCliente(dto.getCliente());
        implantacao.setUsuario(usuario);

        ImplantacaoEntity atualizado = implantacaoRepository.save(implantacao);
        return ImplantacaoMapper.toResponseDTO(atualizado);
    }

    public void deletarImplantacao(Long id) {
        if (!implantacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Implantação não encontrada");
        }
        implantacaoRepository.deleteById(id);
    }
}
