package com.web.Agenda.repository;

import com.web.Agenda.domain.Nota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotaRepository extends JpaRepository<Nota, Integer> {

    
    @Query("from Nota n where n.user = ?1")
    List<Nota> mostrarNotas(Integer user);
    
    
    @Query(nativeQuery = true , value = "call insertaNota(:user,:titulo,:notas,:fecha)")
    void insertaNota(String user,String titulo,String notas,String fecha);
}
