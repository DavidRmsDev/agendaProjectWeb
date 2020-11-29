package com.web.Agenda.controller;

import com.web.Agenda.domain.Nota;
import com.web.Agenda.domain.Usuario;
import com.web.Agenda.service.NotaService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ListadoNotasController {

    private final NotaService notaService;
    private Usuario usuarioId;
    private int estado;

    public ListadoNotasController(NotaService notaService) {
        this.notaService = notaService;
    }

    @RequestMapping("/Notas")
    public String listarNotas(Model model, @ModelAttribute("UsuarioLoged") Usuario userLoged) {
        int estados = estado;
        estado = 0;
        if (userLoged.getUser() != null) {
            this.usuarioId = userLoged;
            List<Nota> listaNotas = notaService.mostrarNotas(usuarioId.getUser());
            Nota nota = new Nota();
            model.addAttribute("usuario", usuarioId.getUser());
            model.addAttribute("nota", nota);
            model.addAttribute("listaNotas", listaNotas);
            model.addAttribute("estado", estados);
            return "crudNotas";
        }
        return "redirect:/";
    }

    @RequestMapping("/Notas/NavBarContactos")
    public String loadContactos(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }

    @RequestMapping("/Notas/NavBarNotas")
    public String loadNotas(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @RequestMapping("/Notas/NavBarRecordatorios")
    public String loadRecordatorios(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Notas/saveNota", params = "botoncillo=create")
    public String guardar(@ModelAttribute Nota nota, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (nota != null) {
                nota.setUser(usuarioId.getUser());
                String fecha = crearFecha();
                nota.setFecha(fecha);
                estado = notaService.guardar(nota);
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Notas/saveNota", params = "botoncillo=modify")
    public String modificar(@ModelAttribute Nota nota, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (nota != null) {
                nota.setUser(usuarioId.getUser());
                String fecha = crearFecha();
                nota.setFecha(fecha);
                notaService.modificar(nota);
                estado = 3;
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Notas/saveNota", params = "botoncillo=delete")
    public String eliminar(@ModelAttribute Nota nota, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (nota != null) {
                notaService.eliminar(nota);
                estado = 4;
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/Notas/saveNota")
    public String eliminar() {
        return "redirect:/";
    }

    public String crearFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM HH:mm:ss yyyy",Locale.forLanguageTag("es-ES"));
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
        return dateFormat.format(new Date());
    }

}
