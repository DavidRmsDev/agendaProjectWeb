/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.Agenda.service;

import com.web.Agenda.domain.Recordatorio;
import com.web.Agenda.repository.RecordatorioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordatorioService {

    @Autowired
    private final RecordatorioRepository recordatorioRepository;

    public RecordatorioService(RecordatorioRepository recordatorioRepository) {
        this.recordatorioRepository = recordatorioRepository;
    }

    public List<Recordatorio> mostrarRecordatorios(Integer user) {
        return recordatorioRepository.mostrarRecordatorios(user);
    }

    public int guardar(Recordatorio recordatorio) {
        recordatorio.setId(null);
      try{
      recordatorioRepository.save(recordatorio);
      return 1;
      }
      catch(Exception e){
          return 2;
      }
    }

    public void modificar(Recordatorio recordatorio) {
        recordatorioRepository.save(recordatorio);
    }

    public void eliminar(Recordatorio recordatorio) {
        recordatorioRepository.delete(recordatorio);
    }

}
