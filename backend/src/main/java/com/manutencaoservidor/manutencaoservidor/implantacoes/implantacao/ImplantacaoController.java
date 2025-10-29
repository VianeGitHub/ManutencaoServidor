package com.manutencaoservidor.manutencaoservidor.implantacoes.implantacao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/implantacoes")
@RequiredArgsConstructor
public class ImplantacaoController {

    private final ImplantacaoService implantacaoService;

    @PostMapping
    public ResponseEntity<ImplantacaoResponseDTO> criar(@RequestBody ImplantacaoRequestDTO dto) {
        return ResponseEntity.ok(implantacaoService.criarImplantacao(dto));
    }

    @GetMapping
    public ResponseEntity<List<ImplantacaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(implantacaoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImplantacaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(implantacaoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImplantacaoResponseDTO> atualizar(@PathVariable Long id,
                                                            @RequestBody ImplantacaoRequestDTO dto) {
        return ResponseEntity.ok(implantacaoService.atualizarImplantacao(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        implantacaoService.deletarImplantacao(id);
        return ResponseEntity.noContent().build();
    }
}
