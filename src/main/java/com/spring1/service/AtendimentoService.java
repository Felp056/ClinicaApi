package com.spring1.service;

import com.spring1.model.Atendimento;
import com.spring1.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {
    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository repository) {
        this.atendimentoRepository = repository;
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public Atendimento save(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }
}
