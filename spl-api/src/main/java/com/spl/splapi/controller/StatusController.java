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

import com.spl.splapi.model.Status;
import com.spl.splapi.service.StatusService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class StatusController implements LoggerUtil {

	@Autowired
	 private StatusService statusService;
	
	@GetMapping("/status/")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getStatuses() {
		return ResponseEntity.ok(statusService.getAll());
	}
	
	@GetMapping("/status/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getStatus(@PathVariable int id) {
		return ResponseEntity.ok(statusService.getById(id));
	}
	
	@PostMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setStatus(@RequestBody Status status) {
		return ResponseEntity.ok(statusService.save(status));
	}
	
	@PutMapping("/status/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putStatus(@PathVariable int id, @RequestBody Status status) {
		return ResponseEntity.ok(statusService.updateById(id, status));
	}
	
	@DeleteMapping("/status/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteStatus(@PathVariable int id) {
		return ResponseEntity.ok(statusService.deleteById(id));
	}
}
