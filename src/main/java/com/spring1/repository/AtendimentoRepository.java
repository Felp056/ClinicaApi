package com.spring1.repository;

import com.spring1.model.Atendimento;
import com.spring1.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {

    List<Atendimento> findByPaciente(Paciente paciente);
}
