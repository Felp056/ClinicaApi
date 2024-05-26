package com.spring1.repository;

import com.spring1.model.Medico;
import com.spring1.service.MedicoService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Medico findMedicoById(int id);
    Medico findMedicoByNome(String nome);
}
