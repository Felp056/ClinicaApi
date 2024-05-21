package com.spring1.controller.medicoController;

import com.spring1.model.Medico;
import com.spring1.service.MedicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name ="Medico_Api")
@RestController
public class MedicoApiController {
    private final MedicoService medicoRepository;
    private final GenericResponseService responseBuilder;

    public MedicoApiController(MedicoService med, GenericResponseService responseBuilder) {
        this.medicoRepository = med;
        this.responseBuilder = responseBuilder;
    }
    @GetMapping(path = "/medicos")
    public List<Medico> getMedicos() { return medicoRepository.findAll();}
    @PostMapping(path = "/medico")
    public Medico getMedicoById(int id) {return medicoRepository.findById(id);}
    @PostMapping(path = "/addmedico")
    public ResponseEntity<Medico> addMedico(@RequestBody Medico m) { return ResponseEntity.ok(medicoRepository.save(m));}
    @PostMapping(path = "/atualizarmedico")
    public ResponseEntity<Medico> updateMedico(@RequestBody Medico m) {return ResponseEntity.ok(medicoRepository.update(m));}
    @DeleteMapping(path = "/deletarmedico")
    public ResponseEntity deleteMedico(@RequestBody Medico m) {
        medicoRepository.delete(m);
        return ResponseEntity.ok("Deletado com sucesso");
    }
}
