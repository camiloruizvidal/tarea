package com.tareas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_persona")
public class TblPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	@Column(name = "nombre_primero")
	public String nombre_primero;
	
	@Column(name = "nombre_segundo")
	public String nombre_segundo;
	
	@Column(name = "apellido_primero")
	public String apellido_primero;
	
	@Column(name = "apellido_segundo")
	public String apellido_segundo;
	
	@Column(name = "fecha_nacimiento")
	public Date fecha_nacimiento = new Date();
	
	@Column(name = "telefono")
	public String telefono;
	
	@Column(name = "direccion")
	public String direccion;
	
	public TblPersona() {
		super();
	}
	public TblPersona(String nombre_primero, String nombre_segundo, String apellido_primero, String apellido_segundo,
			Date fecha_nacimiento, String telefono, String direccion) {
		super();
		this.nombre_primero = nombre_primero;
		this.nombre_segundo = nombre_segundo;
		this.apellido_primero = apellido_primero;
		this.apellido_segundo = apellido_segundo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre_primero() {
		return nombre_primero;
	}
	public void setNombre_primero(String nombre_primero) {
		this.nombre_primero = nombre_primero;
	}
	public String getNombre_segundo() {
		return nombre_segundo;
	}
	public void setNombre_segundo(String nombre_segundo) {
		this.nombre_segundo = nombre_segundo;
	}
	public String getApellido_primero() {
		return apellido_primero;
	}
	public void setApellido_primero(String apellido_primero) {
		this.apellido_primero = apellido_primero;
	}
	public String getApellido_segundo() {
		return apellido_segundo;
	}
	public void setApellido_segundo(String apellido_segundo) {
		this.apellido_segundo = apellido_segundo;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
