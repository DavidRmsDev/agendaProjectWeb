package com.web.Agenda.repository;


import com.web.Agenda.domain.Recordatorio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordatorioRepository extends JpaRepository<Recordatorio, Integer> {

    
    @Query("from Recordatorio r where r.user = ?1")
    List<Recordatorio> mostrarRecordatorios(Integer user);
    
    
    @Query(nativeQuery = true , value = "call insertaRecordatorio(:user,:titulo,:fecha,:hora,:descripcion)")
    void insertaRecordatorio(String user,String titulo,String fecha,String hora,String descripcion);
}
