package com.spring1.controller;

import com.spring1.model.Usuario;
import com.spring1.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name ="Usuario_Api")
@RestController
public class UsuarioApiController {

    private final UsuarioService usuarioService;
    public UsuarioApiController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping(path = "/usuario")
    public ResponseEntity<List<Usuario>> getAll()
    {
        return ResponseEntity.ok(this.usuarioService.findAll());
    }
    @PostMapping(path = "/api/usuarios")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario)
    {
     return ResponseEntity.ok(this.usuarioService.save(usuario));
    }
}
