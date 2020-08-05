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
import com.tareas.model.TblTareas;
import com.tareas.repository.TblTareasRepository;

@RestController
public class TblTareasController {
	@Autowired
	private TblTareasRepository tblTareasRepository;

	@GetMapping("/tareas")
	public List<TblTareas> index()
	{
		return this.tblTareasRepository.findAll();
	}
	@GetMapping("/tareas/{id}")
	public ResponseEntity<TblTareas> show(@PathVariable (value = "id") Long id)  throws ResourceNotFoundException
	{
		TblTareas persona = this.tblTareasRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Id Type Not Found " + id.toString()));
		return ResponseEntity.ok().body(persona);
	}
	
	@PostMapping("/tareas")
	public TblTareas Store(@RequestBody TblTareas request)
	{
		return this.tblTareasRepository.save(request);
	}
	
	@PutMapping("/tareas/{id}")
	public ResponseEntity<TblTareas> update(@PathVariable(value = "id") Long id, @RequestBody TblTareas request) throws ResourceNotFoundException 
	{
		TblTareas tblTarea= tblTareasRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		tblTarea.setId_persona(request.getId_persona());
		tblTarea.setTitulo(request.getTitulo());
		tblTarea.setDescripcion(request.getDescripcion());
		tblTarea.setFecha_expiracion(request.getFecha_expiracion());
		tblTarea.setRealizada(request.getRealizada());
		final TblTareas updated = tblTareasRepository.save(tblTarea);
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/tareas/{id}")
	public Map<String, Boolean> destroy(@PathVariable(value = "id") Long id) throws ResourceNotFoundException
	{
		TblTareas tblTarea = tblTareasRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		tblTareasRepository.delete(tblTarea);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
