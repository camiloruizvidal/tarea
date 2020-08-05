package com.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tareas.model.TblTareas;


@Repository
public interface TblTareasRepository extends JpaRepository<TblTareas, Long> {

}
