package com.spring1.controller;

import com.spring1.model.Usuario;
import com.spring1.repository.UsuarioRepository;
import com.spring1.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioWebController {
    private final UsuarioService usuarioService;
    public UsuarioWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @GetMapping(path = "/usuarios")
    public String getAllUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "Usuarios";
    }

    @PostMapping(path = "/usuarios/save")
    public String saveUsuario(Usuario usuario)
    {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }
}
