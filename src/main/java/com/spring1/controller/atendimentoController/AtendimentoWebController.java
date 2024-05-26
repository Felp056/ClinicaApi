package com.spring1.controller.atendimentoController;

import com.spring1.model.Atendimento;
import com.spring1.model.AtendimentoDTO;
import com.spring1.model.Medico;
import com.spring1.model.Paciente;
import com.spring1.service.AtendimentoService;
import com.spring1.service.MedicoService;
import com.spring1.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AtendimentoWebController {

    private final AtendimentoService atendimentoService;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    public AtendimentoWebController(AtendimentoService atendimentoService, MedicoService medicoService, PacienteService pacienteService) {
        this.atendimentoService = atendimentoService;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    @GetMapping(path = "/atendimentos")
    public String getAllAtendimentos(Model model) {

        List<Atendimento> atendimentos = atendimentoService.findAll();
        model.addAttribute("atendimentos", atendimentos);

        List<Medico> medicos = medicoService.findAll();
        model.addAttribute("medicos", medicos);

        List<Paciente> pacientes = pacienteService.findAll();
        model.addAttribute("pacientes", pacientes);

        return "Atendimentos";
    }

    @PostMapping(path = "/atendimentos/save")
    public String saveAtendimento(AtendimentoDTO atendimentoDTO) {

        System.out.println("Medico: "+atendimentoDTO.getMedico());
        System.out.println("Paciente: "+atendimentoDTO.getPaciente());

        Atendimento atendimento = new Atendimento();
        Medico medico = medicoService.findByNome(atendimentoDTO.getMedico());
        Paciente paciente = pacienteService.findByNome(atendimentoDTO.getPaciente());

        atendimento.setData_hora(LocalDateTime.now());
        atendimento.setAnamnese(atendimentoDTO.getAnamnese());
        atendimento.setMedico(medico);
        atendimento.setPaciente(paciente);

        atendimentoService.save(atendimento);

        return "redirect:/atendimentos";
    }
}
