/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.Agenda.service;

import com.web.Agenda.domain.Usuario;
import com.web.Agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario comprobarUsuario(Usuario usuario) {
        return usuarioRepository.findByNickname(usuario.getNickname());
    }
    
    public Usuario devolverUsuario(int usuario) {
        return usuarioRepository.findByUser(usuario);
    }
    
    public Usuario comprobarUsuarioYContrasenia(Usuario usuario) {
        return usuarioRepository.findByNicknameAndPassword(usuario.getNickname(),usuario.getPassword());
    }

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
/*
    public void modificar(Usuario usuario) {
      usuarioRepository.save(usuario);
    }

    public void eliminar(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
*/
}
