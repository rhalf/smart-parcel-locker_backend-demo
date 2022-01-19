package com.spl.splapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spl.splapi.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
}