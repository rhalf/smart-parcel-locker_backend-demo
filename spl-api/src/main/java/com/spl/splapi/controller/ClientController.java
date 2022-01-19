package com.spl.splapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spl.splapi.model.Client;
import com.spl.splapi.service.ClientService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class ClientController implements LoggerUtil {

	@Autowired
	 private ClientService clientService;
	
	@GetMapping("/clients")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getClients() {
		return ResponseEntity.ok(clientService.getAll());
	}
	
	@GetMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getClient(@PathVariable int id) {
		return ResponseEntity.ok(clientService.getById(id));
	}
	
	@PostMapping("/clients")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setClient(@RequestBody Client client) {
		return ResponseEntity.ok(clientService.save(client));
	}
	
	@PutMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putClient(@PathVariable int id, @RequestBody Client client) {
		return ResponseEntity.ok(clientService.updateById(id, client));
	}
	
	@DeleteMapping("/clients/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteClient(@PathVariable int id) {
		return ResponseEntity.ok(clientService.deleteById(id));
	}
}
