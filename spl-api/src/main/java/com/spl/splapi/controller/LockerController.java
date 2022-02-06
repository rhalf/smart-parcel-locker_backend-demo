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

import com.spl.splapi.model.Locker;
import com.spl.splapi.service.LockerService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class LockerController implements LoggerUtil {

	@Autowired
	 private LockerService lockerService;
	
	@GetMapping("/lockers")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getLockers() {
		return ResponseEntity.ok(lockerService.getAll());
	}
	
	@GetMapping("/locker/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getLocker(@PathVariable int id) {
		return ResponseEntity.ok(lockerService.getById(id));
	}
	
	@PostMapping("/locker")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setLocker(@RequestBody Locker locker) {
		return ResponseEntity.ok(lockerService.save(locker));
	}
	
	@PutMapping("/locker/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putLocker(@PathVariable int id, @RequestBody Locker locker) {
		return ResponseEntity.ok(lockerService.updateById(id, locker));
	}
	
	@DeleteMapping("/locker/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteLocker(@PathVariable int id) {
		return ResponseEntity.ok(lockerService.deleteById(id));
	}
}
