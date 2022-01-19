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

import com.spl.splapi.model.Size;
import com.spl.splapi.service.SizeService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class SizeController implements LoggerUtil {

	@Autowired
	 private SizeService sizeService;
	
	@GetMapping("/sizes")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getSizes() {
		return ResponseEntity.ok(sizeService.getAll());
	}
	
	@GetMapping("/sizes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getSize(@PathVariable int id) {
		return ResponseEntity.ok(sizeService.getById(id));
	}
	
	@PostMapping("/sizes")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setSize(@RequestBody Size size) {
		return ResponseEntity.ok(sizeService.save(size));
	}
	
	@PutMapping("/sizes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putSize(@PathVariable int id, @RequestBody Size size) {
		return ResponseEntity.ok(sizeService.updateById(id, size));
	}
	
	@DeleteMapping("/sizes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteSize(@PathVariable int id) {
		return ResponseEntity.ok(sizeService.deleteById(id));
	}
}
