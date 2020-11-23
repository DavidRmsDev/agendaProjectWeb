/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.Agenda.service;

import com.web.Agenda.domain.Nota;
import com.web.Agenda.repository.NotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    @Autowired
    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<Nota> mostrarNotas(Integer user) {
        return notaRepository.mostrarNotas(user);
    }

    public void guardar(Nota nota) {
        try {
            notaRepository.insertaNota(nota.getUser().toString(), nota.getTitulo(), nota.getNotas(), nota.getFecha());
        } catch (Exception e) {
        }
    }

    public void modificar(Nota nota) {
        notaRepository.save(nota);
    }

    public void eliminar(Nota nota) {
        notaRepository.delete(nota);
    }

}
