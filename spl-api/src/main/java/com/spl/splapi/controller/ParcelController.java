package com.spl.splapi.controller;

import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/parcel/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getParcel(@PathVariable int id) {
		return ResponseEntity.ok(parcelService.getById(id));
	}
	
	@PostMapping("/parcel")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setParcel(@RequestBody Parcel parcel) {
		return ResponseEntity.ok(parcelService.save(parcel));
	}
	
	@PutMapping("/parcel/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putParcel(@PathVariable int id, @RequestBody Parcel parcel) {
		return ResponseEntity.ok(parcelService.updateById(id, parcel));
	}
	
	@DeleteMapping("/parcel/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteParcel(@PathVariable int id) {
		return ResponseEntity.ok(parcelService.deleteById(id));
	}
	
	// ====================================================================
	@GetMapping("/parcel")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> findOneBy(@RequestParam(required = false) Map<String, String> qparams) {

		String barcode = qparams.getOrDefault("barcode", "");
		if (!barcode.isBlank() && !barcode.isEmpty())
			return ResponseEntity.ok(parcelService.findFirstByBarcode(barcode));

		String qrcode = qparams.getOrDefault("qrcode", "");
		if (!qrcode.isBlank() && !qrcode.isEmpty())
			return ResponseEntity.ok(parcelService.findFirstByQrcode(qrcode));

		String name = qparams.getOrDefault("name", "");
		if (!name.isBlank() && !name.isEmpty())
			return ResponseEntity.ok(parcelService.findFirstByNameContaining(name));

		return null;
	}
}
