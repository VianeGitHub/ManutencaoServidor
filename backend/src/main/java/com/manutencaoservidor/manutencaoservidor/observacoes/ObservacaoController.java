package com.manutencaoservidor.manutencaoservidor.observacoes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observacoes")
@RequiredArgsConstructor
public class ObservacaoController {

    private final ObservacaoService observacaoService;

    @PostMapping
    public ResponseEntity<ObservacaoResponseDTO> criarObservacao(@RequestBody ObservacaoRequestDTO dto) {
        return ResponseEntity.ok(observacaoService.criarObservacao(dto));
    }

    @GetMapping
    public ResponseEntity<List<ObservacaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(observacaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservacaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(observacaoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        observacaoService.deletarObservacao(id);
        return ResponseEntity.noContent().build();
    }
}
