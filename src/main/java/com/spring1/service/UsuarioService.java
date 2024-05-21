package com.spring1.service;

import com.spring1.model.Usuario;
import com.spring1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> findAll() { return usuarioRepository.findAll(); }

    public Usuario save(Usuario usuario) { return usuarioRepository.save(usuario); }
}
