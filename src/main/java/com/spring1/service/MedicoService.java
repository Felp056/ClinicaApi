package com.spring1.service;

import com.spring1.model.Medico;
import com.spring1.model.Usuario;
import com.spring1.repository.MedicoRepository;
import com.spring1.repository.UsuarioRepository;

import java.util.List;

public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medRepos) {
        this.medicoRepository = medRepos;
    }

    public List<Medico> findAll() { return medicoRepository.findAll(); }
    public Medico save(Medico Med) { return medicoRepository.save(Med); }
    public void delete(Medico Med) { this.medicoRepository.delete(Med); }
    public Medico findById(Integer id){ return medicoRepository.findById(id).get(); }
    public Medico update(Medico Med) { return medicoRepository.save(Med); }
}
