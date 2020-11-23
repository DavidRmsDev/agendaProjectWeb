package com.web.Agenda.controller;

import com.web.Agenda.domain.Contacto;
import com.web.Agenda.domain.Usuario;
import com.web.Agenda.service.ContactoService;
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
    private Usuario usuarioId;
    private int estado;

    public ListadoContactosController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @RequestMapping("/Contactos")
    public String listarContactos(Model model, @ModelAttribute("UsuarioLoged") Usuario userLoged) {
        int estados = estado;
        estado = 0;
        if (userLoged.getUser() != null) {
            this.usuarioId = userLoged;
            Contacto contacto = new Contacto();
            List<Contacto> contact = contactoService.mostrarContactos(usuarioId.getUser());
            model.addAttribute("usuario", usuarioId);
            model.addAttribute("contacto", contacto);
            model.addAttribute("contactos", contact);
            model.addAttribute("estado", estados);
            return "crudContactos";
        }
        return "redirect:/";
    }

    @RequestMapping("/Contactos/NavBarContactos")
    public String loadContactos(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }

    @RequestMapping("/Contactos/NavBarNotas")
    public String loadNotas(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @RequestMapping("/Contactos/NavBarRecordatorios")
    public String loadRecordatorios(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Contactos/saveContacto", params = "botoncillo=create")
    public String guardar(@ModelAttribute Contacto contacto, Model model, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (contacto != null) {
                contacto.setUser(usuarioId.getUser());
                estado = contactoService.guardar(contacto);
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/Contactos/saveContacto")
    public String guardar() {
        return "redirect:/";
    }

    @PostMapping(value = "/Contactos/saveContacto", params = "botoncillo=modify")
    public String modificar(@ModelAttribute Contacto contacto, Model model, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (contacto != null) {
                contacto.setUser(usuarioId.getUser());
                if (contactoService.modificar(contacto) == 1) {
                    estado = 3;
                } else {
                    estado = 4;
                }
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Contactos/saveContacto", params = "botoncillo=delete")
    public String eliminar(@ModelAttribute Contacto contacto, Model model, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (contacto != null) {
                contactoService.eliminar(contacto);
                estado = 5;
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }
}
