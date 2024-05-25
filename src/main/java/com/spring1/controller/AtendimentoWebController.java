package com.spring1.controller;

import com.spring1.model.Atendimento;
import com.spring1.model.Medico;
import com.spring1.service.AtendimentoService;
import com.spring1.service.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AtendimentoWebController {

    private final AtendimentoService atendimentoService;
    private final MedicoService medicoService;


    public AtendimentoWebController(AtendimentoService atendimentoService, MedicoService medicoService) {
        this.atendimentoService = atendimentoService;
        this.medicoService = medicoService;

    }

    @GetMapping(path = "/atendimentos")
    public String getAllAtendimentos(Model model) {
        List<Atendimento> atendimentos = atendimentoService.findAll();
        model.addAttribute("atendimentos", atendimentos);

        return "Atendimentos";
    }

    @PostMapping(path = "/atendimentos/save")
    public String saveAtendimento(Atendimento atendimento) {
        atendimentoService.save(atendimento);

        return "redirect:/atendimentos";
    }

    @RequestMapping(value = "/populateDropDownList", method = RequestMethod.GET)
    public String populateList(Model model) {
        List<Medico> medicos = this.medicoService.findAll();

        for (Medico medico : medicos) {
            String sMedico
            model.addAttribute(, "medico")
        }
        return "dropDownList/dropDownList.html";
    }
}
