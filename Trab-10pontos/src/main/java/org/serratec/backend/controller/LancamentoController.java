package org.serratec.backend.controller;

import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.service.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    private final LancamentoService lancamentoService;

    public LancamentoController(LancamentoService lancamentoService) {
        this.lancamentoService = lancamentoService;
    }

    @GetMapping("/id")
    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id) {
        LancamentoVendasResponseDTO dto = lancamentoService.listarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<LancamentoVendas> inserirLancamento(@Valid @RequestBody LancamentoVendasRequestDTO dto) {
        LancamentoVendas lancamentoSalvo = lancamentoService.inserirLancamento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }
}
