package com.spring1.service;

import com.spring1.model.Medico;
import com.spring1.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medRepos) {
        this.medicoRepository = medRepos;
    }

    public List<Medico> findAll() { return medicoRepository.findAll(); }
    public Medico findByNome(String nome) {
        return medicoRepository.findMedicoByNome(nome);
    }
    public Medico save(Medico Med) { return medicoRepository.save(Med); }
    public void delete(Medico Med) { this.medicoRepository.delete(Med); }
    public Medico findById(Integer id){ return medicoRepository.findMedicoById(id); }
    public Medico update(Medico Med) { return medicoRepository.save(Med); }
}
