package com.web.Agenda.controller;

import com.web.Agenda.domain.Contacto;
import com.web.Agenda.domain.Usuario;
import com.web.Agenda.service.ContactoService;
import com.web.Agenda.service.UsuarioService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ListadoContactosController {

    private final ContactoService contactoService;
    private final UsuarioService usuarioService;
    private int usuarioId;

    public ListadoContactosController(ContactoService contactoService, UsuarioService usuarioService) {
        this.contactoService = contactoService;
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/Contactos")
    public String listarContactos(Model model, @ModelAttribute("controladorLogin") Usuario usuarioLogin) {
        if (usuarioLogin.getUser() != null) {
            this.usuarioId = usuarioLogin.getUser();
            Contacto contacto = new Contacto();
            List<Contacto> contact = contactoService.mostrarContactos(usuarioId);
            model.addAttribute("usuario", usuarioId);
            model.addAttribute("contacto", contacto);
            model.addAttribute("contactos", contact);
            return "crudContactos";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Contactos/Acciones", params = "botoncillo=create")
    public String guardar(@ModelAttribute Contacto contacto, Model model, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            if (contacto != null) {
                contacto.setUser(usuarioId);
                contactoService.guardar(contacto);
                System.out.println("Contacto guardado");
            }
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Contactos/Acciones", params = "botoncillo=modify")
    public String modificar(@ModelAttribute Contacto contacto, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            if (contacto != null) {
                contacto.setUser(usuarioId);
                contactoService.modificar(contacto);
                System.out.println("Contacto modificado");
            }
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Contactos/Acciones", params = "botoncillo=delete")
    public String eliminar(@ModelAttribute Contacto contacto, RedirectAttributes redi) {
        if (usuarioId != 0) {
        redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
        if (contacto != null) {
            contactoService.eliminar(contacto);
            System.out.println("Contacto eliminado");
        }
        return "redirect:/Contactos";
        }
        return "redirect:/";
    }
}
