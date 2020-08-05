package com.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tareas.model.TblPersona;



@Repository
public interface TblPersonaRepository extends JpaRepository<TblPersona, Long> {

}
