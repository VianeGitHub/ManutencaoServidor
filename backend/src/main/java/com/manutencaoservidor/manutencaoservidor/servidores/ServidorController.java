package com.manutencaoservidor.manutencaoservidor.servidores;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servidores")
@RequiredArgsConstructor
public class ServidorController {

    private final ServidorService servidorService;

    @PostMapping
    public ResponseEntity<ServidorResponseDTO> criarServidor(@RequestBody ServidorRequestDTO dto) {
        return ResponseEntity.ok(servidorService.criarServidor(dto));
    }

    @GetMapping
    public ResponseEntity<List<ServidorResponseDTO>> listarTodosServidores() {
        return ResponseEntity.ok(servidorService.listarTodosServidores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorResponseDTO> buscarServidorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servidorService.buscarServidorPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorResponseDTO> atualizarServidor(@PathVariable Long id, @RequestBody ServidorRequestDTO dto) {
        return ResponseEntity.ok(servidorService.atualizarServidor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServidor(@PathVariable Long id) {
        servidorService.deletarServidor(id);
        return ResponseEntity.noContent().build();
    }
}
