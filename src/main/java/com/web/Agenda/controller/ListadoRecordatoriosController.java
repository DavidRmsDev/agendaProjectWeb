package com.web.Agenda.controller;

import com.web.Agenda.domain.Recordatorio;
import com.web.Agenda.service.RecordatorioService;
import com.web.Agenda.service.UsuarioService;
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
    private final UsuarioService usuarioService;
    private int usuarioId;

    public ListadoRecordatoriosController(RecordatorioService recordatorioService, UsuarioService usuarioService) {
        this.recordatorioService = recordatorioService;
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/Recordatorios")
    public String listarRecordatorios(Model model, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            List<Recordatorio> listaRecordatorios = recordatorioService.mostrarRecordatorios(usuarioId);
            Recordatorio recordatorio = new Recordatorio();
            model.addAttribute("usuario", usuarioId);
            model.addAttribute("recordatorio", recordatorio);
            model.addAttribute("listaRecordatorios", listaRecordatorios);
            return "crudRecordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Recordatorios/saveRecordatorio", params = "botoncillo=create")
    public String guardar(@ModelAttribute Recordatorio recordatorio, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            if (recordatorio != null) {
                recordatorio.setUser(usuarioId);
                recordatorioService.guardar(recordatorio);
                System.out.println("Recordatorio guardado");
            }
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Recordatorios/saveRecordatorio", params = "botoncillo=modify")
    public String modificar(@ModelAttribute Recordatorio recordatorio, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            if (recordatorio != null) {
                recordatorio.setUser(usuarioId);
                recordatorioService.modificar(recordatorio);
                System.out.println("Recordatorio modificado");
            }
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Recordatorios/saveRecordatorio", params = "botoncillo=delete")
    public String eliminar(@ModelAttribute Recordatorio recordatorio, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));

            if (recordatorio != null) {
                recordatorioService.eliminar(recordatorio);
                System.out.println("Recordatorio eliminado");
            }
            return "redirect:/Recordatorios";
        }
        return "redirect:/";
    }
}
