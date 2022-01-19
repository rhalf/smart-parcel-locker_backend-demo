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

import com.spl.splapi.model.Courier;
import com.spl.splapi.service.CourierService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class CourierController implements LoggerUtil {

	@Autowired
	 private CourierService courierService;
	
	@GetMapping("/couriers")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getCouriers() {
		return ResponseEntity.ok(courierService.getAll());
	}
	
	@GetMapping("/couriers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getCourier(@PathVariable int id) {
		return ResponseEntity.ok(courierService.getById(id));
	}
	
	@PostMapping("/couriers")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setCourier(@RequestBody Courier courier) {
		return ResponseEntity.ok(courierService.save(courier));
	}
	
	@PutMapping("/couriers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putCourier(@PathVariable int id, @RequestBody Courier courier) {
		return ResponseEntity.ok(courierService.updateById(id, courier));
	}
	
	@DeleteMapping("/couriers/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteCourier(@PathVariable int id) {
		return ResponseEntity.ok(courierService.deleteById(id));
	}
}
