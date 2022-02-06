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

import com.spl.splapi.model.Transaction;
import com.spl.splapi.service.TransactionService;
import com.spl.splapi.util.LoggerUtil;

@RestController
@RequestMapping("/v1")
public class TransactionController implements LoggerUtil {

	@Autowired
	 private TransactionService transactionService;
	
	@GetMapping("/transactions")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getTransactions() {
		return ResponseEntity.ok(transactionService.getAll());
	}
	
	@GetMapping("/transaction/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> getTransaction(@PathVariable int id) {
		return ResponseEntity.ok(transactionService.getById(id));
	}
	
	@PostMapping("/transaction")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> setTransaction(@RequestBody Transaction transaction) {
		return ResponseEntity.ok(transactionService.save(transaction));
	}
	
	@PutMapping("/transaction/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> putTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
		return ResponseEntity.ok(transactionService.updateById(id, transaction));
	}
	
	@DeleteMapping("/transaction/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteTransaction(@PathVariable int id) {
		return ResponseEntity.ok(transactionService.deleteById(id));
	}
}
