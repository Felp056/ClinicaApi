package com.spring1.controller;

import com.spring1.model.Paciente;
import com.spring1.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Tag(name="Api Paciente", description = "Endpoint para operações com os Pacientes")
@Controller
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(path = "/pacientes")
    public String getAllPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.findAll();
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }

    @PostMapping(path = "/pacientes/save")
    public String savePaciente(Paciente paciente) {
        pacienteService.save(paciente);
        return "redirect:/pacientes";
    }

    @PostMapping(path = "/pacientes/delete")
    public String deletePaciente(Paciente paciente) {
        pacienteService.Delete(paciente);
    return "redirect:/pacientes";}

    @PostMapping(path = "/pacientes")
    public ResponseEntity getByIdPacientes(@RequestBody long id) {
          return  ResponseEntity.ok(pacienteService.findById(id));
    }

    @PostMapping(path = "/pacientes/nome")
    public ResponseEntity getByNomePacientes(@RequestBody String nome) {
        return  ResponseEntity.ok(pacienteService.findByNome(nome));
    }
}
