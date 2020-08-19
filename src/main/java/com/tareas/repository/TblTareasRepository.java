package com.tareas.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tareas.model.TblTareas;


@Repository
public interface TblTareasRepository extends JpaRepository<TblTareas, Long> {
    EntityManager em = null;
	
	@Query(value = "select u.id, u.titulo, u.descripcion, u.fecha_expiracion, u.realizada, u.id_persona from tbl_tareas u where  u.id_persona = ?1", nativeQuery=true)
	List<TblTareas> findByIdPersona(@Param("id_persona") Long id_persona);
	  
	@Query(value = "SELECT "+
			"u.id as id_tarea, " + 
			"u.titulo, " + 
			"u.descripcion, " + 
			"u.fecha_expiracion, " + 
			"u.realizada, " + 
			"u.id_persona, " + 
			"p.nombre_primero, " + 
			"p.nombre_segundo, " + 
			"p.apellido_primero, " + 
			"p.apellido_segundo, " + 
			"p.fecha_nacimiento, " + 
			"p.telefono, " + 
			"p.direccion, " + 
			"p.id " + 
			"FROM "+
			"public.tbl_tareas u " + 
			"INNER JOIN public.tbl_persona p ON u.id_persona = p.id "+
			"where  u.id_persona = ?1", nativeQuery=true)
	List<Object> findAllTareas(@Param("id_persona") Long id_persona);
	
	@Query(value = "SELECT count(*) as total from tbl_tareas u", nativeQuery=true)
	List<Object> findTest();
	  
	
}