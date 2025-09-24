package com.manutencaoservidor.manutencaoservidor.clientes;

import com.manutencaoservidor.manutencaoservidor.servidores.ServidorEntity;
import com.manutencaoservidor.manutencaoservidor.servidores.ServidorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ServidorRepository servidorRepository;

    public ClienteResponseDTO criarCliente(ClienteRequestDTO dto) {
        ServidorEntity servidor = servidorRepository.findById(dto.getServidorId())
                .orElseThrow(() -> new EntityNotFoundException("Servidor não encontrado"));

        ClienteEntity cliente = ClienteMapper.toEntity(dto, servidor);
        ClienteEntity salvo = clienteRepository.save(cliente);

        return ClienteMapper.toResponseDTO(salvo);
    }

    public List<ClienteResponseDTO> listarTodosClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ClienteResponseDTO buscarClientePorId(Long id) {
        ClienteEntity cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return ClienteMapper.toResponseDTO(cliente);
    }

    public ClienteResponseDTO atualizarCliente(Long id, ClienteRequestDTO dto) {
        ClienteEntity cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

        ServidorEntity servidor = servidorRepository.findById(dto.getServidorId())
                .orElseThrow(() -> new EntityNotFoundException("Servidor não encontrado"));

        cliente.setNomeCliente(dto.getNomeCliente());
        cliente.setCnpjCliente(dto.getCnpjCliente());
        cliente.setSituacaoAtual(dto.getSituacaoAtual());
        cliente.setServidor(servidor);

        ClienteEntity atualizado = clienteRepository.save(cliente);
        return ClienteMapper.toResponseDTO(atualizado);
    }

    public void deletarCliente(Long id) {
        if(!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
