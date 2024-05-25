package com.spring1.controller.medicoController;

import com.spring1.model.Medico;
import com.spring1.model.Usuario;
import com.spring1.service.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MedicoWebController {
    private final MedicoService medicoService;
    MedicoApiController ApiController;
    public MedicoWebController(MedicoService medicoService) {
        this.medicoService = medicoService;
        ApiController = new MedicoApiController(medicoService);
    }

    @GetMapping(path = "/medicosLista")
    public String getAllMedicos(Model model) {
        List<Medico> medico = medicoService.findAll();
        model.addAttribute("medicos", medico);
        return "CadastroMedico";
    }
    @PostMapping(path = "/medicos/save")
    public String saveUsuario(Medico med)
    {
        MedicoApiController gg = new MedicoApiController(medicoService);
        ApiController.addMedico(med);
        return "redirect:/medicosLista";
    }
}
