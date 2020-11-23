package com.web.Agenda.repository;



import com.web.Agenda.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  /*  
    @Query("from Usuario u where u.user = ?1")
    List<Usuario> mostrarUsuarios(Integer user);
    
   
    @Query(nativeQuery = true , value = "call comprobarNombreUsuario(:nick)")
    Usuario comprobarNombreUsuario(String nick);
     */
    Usuario findByNickname(String nickname);
    
    @Query("from Usuario u where u.nickname = ?1 and u.password = ?2")
    Usuario findByNicknameAndPassword(String nickname, String Password);
}
