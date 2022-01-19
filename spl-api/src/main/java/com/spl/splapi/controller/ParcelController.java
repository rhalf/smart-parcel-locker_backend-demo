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

import com.spl.splapi.model.Parcel;
import com.spl.splapi.service.ParcelService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class ParcelController implements LoggerUtil {

	@Autowired
	 private ParcelService parcelService;
	
	@GetMapping("/parcels")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getParcels() {
		return ResponseEntity.ok(parcelService.getAll());
	}
	
	@GetMapping("/parcels/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getParcel(@PathVariable int id) {
		return ResponseEntity.ok(parcelService.getById(id));
	}
	
	@PostMapping("/parcels")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setParcel(@RequestBody Parcel parcel) {
		return ResponseEntity.ok(parcelService.save(parcel));
	}
	
	@PutMapping("/parcels/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putParcel(@PathVariable int id, @RequestBody Parcel parcel) {
		return ResponseEntity.ok(parcelService.updateById(id, parcel));
	}
	
	@DeleteMapping("/parcels/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteParcel(@PathVariable int id) {
		return ResponseEntity.ok(parcelService.deleteById(id));
	}
}
