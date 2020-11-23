/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.Agenda.service;

import com.web.Agenda.domain.Contacto;
import com.web.Agenda.repository.ContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {

    @Autowired
    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public List<Contacto> mostrarContactos(Integer user) {
        return contactoRepository.mostrarContactos(user);
    }

   public void guardar(Contacto contacto) {
        try {
            contactoRepository.insertaContacto(contacto.getUser().toString(), contacto.getNombre(), contacto.getApellidos(),contacto.getTelefono(), contacto.getDireccion(),contacto.getEmail());
        } catch (Exception e) {
        }
    }

    public void modificar(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    public void eliminar(Contacto contacto) {
        contactoRepository.delete(contacto);
    }


}
