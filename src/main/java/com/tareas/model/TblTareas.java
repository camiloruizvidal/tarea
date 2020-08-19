package com.tareas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tareas")
public class TblTareas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true, name = "id")
	private Long id;
	
	@Column(name = "id_persona")
	private Integer id_persona;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_expiracion")
	private Date fecha_expiracion = new Date();
	
	@Column(name = "realizada")
	private Boolean realizada = false;
	
	public TblTareas(Long id, Integer id_persona, String titulo, String descripcion, Date fecha_expiracion, Boolean realizada)
	{
		super();
		this.id = id;
		this.id_persona = id_persona;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha_expiracion = fecha_expiracion;
		this.realizada = realizada;
	}
	public TblTareas() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getId_persona() {
		return id_persona;
	}
	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha_expiracion() {
		return fecha_expiracion;
	}
	public void setFecha_expiracion(Date fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
	}
	public Boolean getRealizada() {
		return realizada;
	}
	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}
	
}
