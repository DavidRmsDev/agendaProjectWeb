package com.web.Agenda.controller;

import com.web.Agenda.domain.Recordatorio;
import com.web.Agenda.domain.Usuario;
import com.web.Agenda.service.RecordatorioService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ListadoRecordatoriosController {

    private final RecordatorioService recordatorioService;
    private Usuario usuarioId;
    private int estado;

    public ListadoRecordatoriosController(RecordatorioService recordatorioService) {
        this.recordatorioService = recordatorioService;
    }

    @RequestMapping("/Recordatorios")
    public String listarRecordatorios(Model model, @ModelAttribute("UsuarioLoged") Usuario userLoged) {
        int estados = estado;
        estado = 0;
        if (userLoged.getUser() != null) {
            this.usuarioId = userLoged;
            List<Recordatorio> listaRecordatorios = recordatorioService.mostrarRecordatorios(usuarioId.getUser());
            Recordatorio recordatorio = new Recordatorio();
            model.addAttribute("usuario", usuarioId);
            model.addAttribute("recordatorio", recordatorio);
            model.addAttribute("listaRecordatorios", listaRecordatorios);
            model.addAttribute("estado", estados);
            return "crudRecordatorios";
        }
        return "redirect:/";
    }

    @RequestMapping("/Recordatorios/NavBarContactos")
    public String loadContactos(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Contactos";
        }
        return "redirect:/";
    }

    @RequestMapping("/Recordatorios/NavBarNotas")
    public String loadNotas(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @RequestMapping("/Recordatorios/NavBarRecordatorios")
    public String loadRecordatorios(RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Recordatorios/saveRecordatorio", params = "botoncillo=create")
    public String guardar(@ModelAttribute Recordatorio recordatorio, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (recordatorio != null) {
                recordatorio.setUser(usuarioId.getUser());
                estado = recordatorioService.guardar(recordatorio);
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Recordatorios/saveRecordatorio", params = "botoncillo=modify")
    public String modificar(@ModelAttribute Recordatorio recordatorio, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (recordatorio != null) {
                recordatorio.setUser(usuarioId.getUser());
                recordatorioService.modificar(recordatorio);
                estado = 3;
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Recordatorios/saveRecordatorio", params = "botoncillo=delete")
    public String eliminar(@ModelAttribute Recordatorio recordatorio, RedirectAttributes redirectAttributes) {
        if (usuarioId != null) {
            if (recordatorio != null) {
                recordatorioService.eliminar(recordatorio);
                estado = 4;
            }
            redirectAttributes.addFlashAttribute("UsuarioLoged", usuarioId);
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/Recordatorios/saveRecordatorio")
    public String eliminar() {
        return "redirect:/";
    }
}
