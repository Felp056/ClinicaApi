package com.spring1.repository;

import com.spring1.model.Paciente;
import com.spring1.service.PacienteService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    public Paciente findPacienteById(Long id);
    public Paciente findPacienteByNome(String nome);
}
