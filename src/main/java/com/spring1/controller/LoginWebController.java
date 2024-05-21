package com.spring1.controller;

import com.spring1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginWebController {
    private final UsuarioService usuarioService;
    private final HttpSession httpSession;

    public LoginWebController(UsuarioService usuarioService, HttpSession httpSession) {
        this.usuarioService = usuarioService;
        this.httpSession = httpSession;
    }

    @GetMapping("/hello-world")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        String helloWorld = "Hello +"+name+"!";
        return helloWorld;
    }

    @GetMapping("/login")
    public String logInForm(){
        return "Index";
    }

    @PostMapping(path = "/login")
    public String login(@RequestParam("username") String login, @RequestParam("password") String senha, Model model )
    {
        for(int i = 0 ; i < usuarioService.findAll().size() ; i++){
            if(usuarioService.findAll().get(i).getLogin().equals(login) && usuarioService.findAll().get(i).getSenha().equals(senha)){
                httpSession.setAttribute("usuarioLogado", login);
                return "redirect:/bemvindo";
            }
        }
        model.addAttribute("error", "Login ou senha incorreto");
        return "Index";
    }

    @GetMapping(path = "/bemvindo")
    public String bemVindo(){
        return "BemVindo";
    }
}
