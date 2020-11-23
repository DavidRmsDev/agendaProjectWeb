package com.web.Agenda.repository;

import com.web.Agenda.domain.Contacto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    
    @Query("from Contacto c where c.user = ?1 order by c.apellidos")
    List<Contacto> mostrarContactos(Integer user);
    
    @Query(nativeQuery = true , value = "call insertaContacto(:user,:nombre,:apellidos,:telefono,:direccion,:email)")
    void insertaContacto(String user,String nombre,String apellidos,String telefono,String direccion,String email);

}
