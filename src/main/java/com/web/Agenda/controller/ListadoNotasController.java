package com.web.Agenda.controller;

import com.web.Agenda.domain.Nota;
import com.web.Agenda.domain.Usuario;
import com.web.Agenda.service.NotaService;
import com.web.Agenda.service.UsuarioService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ListadoNotasController {

    private final NotaService notaService;
    private final UsuarioService usuarioService;
    private int usuarioId;

    public ListadoNotasController(NotaService notaService, UsuarioService usuarioService) {
        this.notaService = notaService;
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/Notas")
    public String listarNotas(Model model, @ModelAttribute("controladorLogin") Usuario usuarioLogin) {
        if (usuarioLogin.getUser() != null) {
            this.usuarioId = usuarioLogin.getUser();
            List<Nota> listaNotas = notaService.mostrarNotas(usuarioId);
            Nota nota = new Nota();
            model.addAttribute("usuario", usuarioId);
            model.addAttribute("nota", nota);
            model.addAttribute("listaNotas", listaNotas);
            return "crudNotas";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Notas/saveNota", params = "botoncillo=create")
    public String guardar(@ModelAttribute Nota nota, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            if (nota != null) {
                nota.setUser(usuarioId);
                String fecha = crearFecha();
                nota.setFecha(fecha);
                notaService.guardar(nota);
                System.out.println("Nota guardada");
            }
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Notas/saveNota", params = "botoncillo=modify")
    public String modificar(@ModelAttribute Nota nota, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            if (nota != null) {
                nota.setUser(usuarioId);
                String fecha = crearFecha();
                nota.setFecha(fecha);
                notaService.modificar(nota);
                System.out.println("Nota modificada");
            }
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/Notas/saveNota", params = "botoncillo=delete")
    public String eliminar(@ModelAttribute Nota nota, RedirectAttributes redi) {
        if (usuarioId != 0) {
            redi.addFlashAttribute("controladorLogin", usuarioService.devolverUsuario(usuarioId));
            if (nota != null) {
                notaService.eliminar(nota);
                System.out.println("Nota eliminada");
            }
            return "redirect:/Notas";
        }
        return "redirect:/";
    }

    public String crearFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE d MMMM HH:mm:ss yyyy");
        return dateFormat.format(new Date());
    }

}
