package com.spl.splapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spl.splapi.model.Transaction;
import com.spl.splapi.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> getAll() {
		return transactionRepository.findAll();
	}

	public Object getById(int id) {
		return transactionRepository.findById(id).orElse(null);
	}

	public Object save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Object updateById(int id, Transaction transaction) {
		if (Objects.isNull(getById(id)))
			return null;
		return transactionRepository.save(transaction);
	}

	public Object deleteById(int id) {
		if (Objects.isNull(getById(id)))
			return null;
		transactionRepository.deleteById(id);
		return "success";
	}
}
