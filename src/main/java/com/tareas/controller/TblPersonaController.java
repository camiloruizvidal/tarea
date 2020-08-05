package com.tareas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tareas.exception.ResourceNotFoundException;
import com.tareas.model.TblPersona;
import com.tareas.repository.TblPersonaRepository;

import lombok.extern.java.Log;

@RestController
public class TblPersonaController {

	@Autowired
	private TblPersonaRepository tblPersonaRepository;

	@GetMapping("/personas")
	public List<TblPersona> index()
	{
		return this.tblPersonaRepository.findAll();
	}
	
	@GetMapping("/personas/{id}")
	public ResponseEntity<TblPersona> show(@PathVariable (value = "id") Long id) 
	throws ResourceNotFoundException
	{
			TblPersona persona = this.tblPersonaRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Id Type Not Found " + id.toString()));
		return ResponseEntity.ok().body(persona);
	}
	@PostMapping("/personas")
	public TblPersona Store(@RequestBody TblPersona request)
	{
		return this.tblPersonaRepository.save(request);
	}
	@PutMapping("/personas/{id}")
	public ResponseEntity<TblPersona> update(@PathVariable(value = "id") Long id, 
			@RequestBody TblPersona request) 
					throws ResourceNotFoundException 
	{
		TblPersona tblPersona = tblPersonaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		tblPersona.setNombre_primero(request.getNombre_primero());
		tblPersona.setNombre_segundo(request.getNombre_segundo());
		tblPersona.setApellido_primero(request.getApellido_primero());
		tblPersona.setApellido_segundo(request.getApellido_segundo());
		tblPersona.setFecha_nacimiento(request.getFecha_nacimiento());
		tblPersona.setTelefono(request.getTelefono());
		tblPersona.setDireccion(request.getDireccion());
		final TblPersona updated = tblPersonaRepository.save(tblPersona);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/personas/{id}")
	public Map<String, Boolean> destroy(@PathVariable(value = "id") Long id) throws ResourceNotFoundException
	{
		TblPersona tblPersona = tblPersonaRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		tblPersonaRepository.delete(tblPersona);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
