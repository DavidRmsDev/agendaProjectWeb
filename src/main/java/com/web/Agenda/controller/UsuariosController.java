package com.web.Agenda.controller;

import com.web.Agenda.domain.Usuario;
import com.web.Agenda.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuariosController {

    private final UsuarioService usuarioService;
    private int caso;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/")
    public String loadInicio(Model model) {
        int casos = caso;
        caso = 0;
        Usuario usuario = new Usuario();
        model.addAttribute("user", usuario);
        model.addAttribute("caso", casos);
        return "index";
    }

    @PostMapping(value = "/inicio", params = "botoncillo=inicio")
    public String login(@ModelAttribute Usuario usuario, Model model, RedirectAttributes redirectAttributes) {
        caso = logeo(usuario);
        model.addAttribute("caso", caso);
        if (caso == 5) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioService.comprobarUsuario(usuario));
            return "redirect:/Contactos";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping(value = "/inicio", params = "botoncillo=registro")
    public String register(@ModelAttribute Usuario usuario, Model model) {
        caso = registro(usuario);
        if (caso == 4) {
            usuarioService.guardar(usuario);
        }
        model.addAttribute("caso", caso);
        return "redirect:/";
    }

    @RequestMapping(value = "/inicio")
    public String register() {
        return "redirect:/";
    }

    public int logeo(Usuario usuario) {
        if (usuarioService.comprobarUsuario(usuario) != null) {
            if (usuarioService.comprobarUsuarioYContrasenia(usuario) == null) {
                caso = 2;
            } else {
                caso = 5;
            }
        } else {
            caso = 1;
        }
        return caso;
    }

    public int registro(Usuario usuario) {
        int caso = 4;
        if (usuarioService.comprobarUsuario(usuario) != null) {
            caso = 3;
        }
        return caso;
    }
}
