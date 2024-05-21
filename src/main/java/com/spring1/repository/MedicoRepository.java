package com.spring1.repository;

import com.spring1.model.Medico;
import com.spring1.model.Usuario;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Medico findMedicoById(Integer id);
}
