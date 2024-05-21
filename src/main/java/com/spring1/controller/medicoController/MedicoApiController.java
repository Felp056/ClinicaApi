package com.spring1.controller.medicoController;

import com.spring1.model.Medico;
import com.spring1.model.Usuario;
import com.spring1.service.MedicoService;
import com.spring1.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name ="Usuario_Api")
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
    /*
    @GetMapping(path = "/usuario")
    public ResponseEntity<List<Usuario>> getAll()
    {
        return ResponseEntity.ok(this.usuarioService.findAll());
    }
    @PostMapping(path = "/api/usuarios")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario)
    {
        return ResponseEntity.ok(this.usuarioService.save(usuario));
    }*/
}
