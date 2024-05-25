package com.spring1.controller;

import com.spring1.model.Atendimento;
import com.spring1.service.AtendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Atendimento Api", description = "Endpoint para operações com os Atendimentos")
@RestController
public class AtendimentoApiController {

    private final AtendimentoService service;

    public AtendimentoApiController(AtendimentoService service) {
        this.service = service;
    }

    @Operation (
            summary = "Retorna uma lista com todos os Atendimentos",
            description = "Retorna uma lista com o ID, data e hora do atendimento, anamnese, médico e paciente."
    )
    @GetMapping("/atendimento")
    public ResponseEntity<List<Atendimento>> getAllAtendimentos() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @Operation (
            summary = "Salva o Atendimento no banco de dados",
            description = "Salva o Atendimento no banco de dados e retorna o objeto persistido."
    )
    @PostMapping("/atendimento")
    public ResponseEntity<Atendimento> saveAtendimento(Atendimento atendimento) {
        return ResponseEntity.ok(this.service.save(atendimento));
    }
}
