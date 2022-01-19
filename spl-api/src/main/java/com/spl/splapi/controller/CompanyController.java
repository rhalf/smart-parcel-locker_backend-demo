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

import com.spl.splapi.model.Company;
import com.spl.splapi.service.CompanyService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class CompanyController implements LoggerUtil {

	@Autowired
	 private CompanyService companyService;
	
	@GetMapping("/companies")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getCompanys() {
		return ResponseEntity.ok(companyService.getAll());
	}
	
	@GetMapping("/companies/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getCompany(@PathVariable int id) {
		return ResponseEntity.ok(companyService.getById(id));
	}
	
	@PostMapping("/companies")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.save(company));
	}
	
	@PutMapping("/companies/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putCompany(@PathVariable int id, @RequestBody Company company) {
		return ResponseEntity.ok(companyService.updateById(id, company));
	}
	
	@DeleteMapping("/companies/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteCompany(@PathVariable int id) {
		return ResponseEntity.ok(companyService.deleteById(id));
	}
}
