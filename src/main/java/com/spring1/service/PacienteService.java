package com.spring1.service;

import com.spring1.model.Paciente;
import com.spring1.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }
    public Paciente findById(Long id){
        return pacienteRepository.findPacienteById(id);
    }

    public Paciente findByNome(String nome) {
        return pacienteRepository.findPacienteByNome(nome);
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
